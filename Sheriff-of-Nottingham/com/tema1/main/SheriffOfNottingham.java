package com.tema1.main;

import com.tema1.Players.Basic;
import com.tema1.Players.Greedy;
import com.tema1.Players.PlayersFactory;
import com.tema1.goods.Goods;
import com.tema1.goods.GoodsFactory;
import com.tema1.goods.GoodsType;
import com.tema1.goods.LegalGoods;
import com.tema1.utils.Constants;
import com.tema1.utils.Deck;

import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Comparator;

/**
 * Class that implements the game logic.
 * Members:
 *  - static Constants
 *  - Deck deck -> generated using the Deck Singleton.
 *  - LinkdedList<Basic> players
 *  - List<String> playerNames
 *  - int numberOfRounds
 * */

public final class SheriffOfNottingham {
    private static Constants c = new Constants();
    private Deck deck = Deck.getInstance();
    private LinkedList<Basic> players = new LinkedList<Basic>();
    private List<String> playerNames = new LinkedList<String>();
    private int numberOfRounds = c.getZero();

    /**
     * Method that reads data from the gameInput, adds the cards to the deck
     * and asserts the name of players.
     * @param gameInput -> final GameInput : IDs of cards, the name of the players.
     * */
    public void getGameReady(final GameInput gameInput) {
        for (Integer i : gameInput.getAssetIds()) {
            deck.addCards(GoodsFactory.getInstance().getAllGoods().get(i));
        }

        int i = c.getZero();
        playerNames = gameInput.getPlayerNames();

        /*
          Each player is added to the LinkedList using the factory PlayersFactory
         */
        for (String name : gameInput.getPlayerNames()) {
            Basic player = PlayersFactory.getPlayer(name);
            player.setId(i);
            players.add(player);
            ++i;
        }

        numberOfRounds = gameInput.getRounds();
    }

    /**
     * Method that executes the game until each player was sheriff for 5 times.
     * */
    public void playGame() {
        Greedy g = new Greedy();
        for (int i = 0; i < numberOfRounds * players.size(); ++i) {
            if (i % players.size() == c.getZero()) {
                g.increaseRoundNumber();
            }

            Basic sheriff = players.get(i % players.size());
            for (Basic player : players) {
                if (!sheriff.equals(player)) {
                    player.drawCards(deck);
                    player.playMerchant();

                }
            }
            /*
              The sheriff checks the other players based on his algorithm.
             */
            sheriff.playSheriff(deck, players);
        }

    }

    /**
     * Method that computes the final score for each player at the end of the game.
     * The score will be added to the Coins that each player has.
     * */
    public void computeScore() {
        for (Basic player : players) {
            for (AbstractMap.Entry<Goods, Integer> entry : player.getGoodsOnStand().entrySet()) {
                if (entry.getValue() > c.getZero()) {
                    player.addCoins(entry.getValue() * entry.getKey().getProfit());
                }
            }
        }
    }

    /**
     * Method that finds the two players eligible for King's and Queen's bonus.
     * @return int[][][] -> 3D matrix that contains the two players
     * with their IDs and the ammount of legal goods.
     * */
    public int[][][] computeBonuses() {
        int[][][] bonusBoard = new int[c.getMinimumNumberOfPlayers()][c.getMaxCardsInHands() + 1]
                [c.getMinimumNumberOfPlayers()];

        for (Basic player : players) {
            for (AbstractMap.Entry<Goods, Integer> entry : player.getGoodsOnStand().entrySet()) {
                try {
                    if (entry.getKey() == null || entry.getKey().getType() == GoodsType.Illegal) {
                        continue;
                    }

                    int cardId = entry.getKey().getId();

                    if (bonusBoard[0][cardId][1] >= entry.getValue()
                            && entry.getValue() >  bonusBoard[1][cardId][1]
                            && entry.getValue() > c.getZero()
                        && bonusBoard[0][cardId][0] != player.getId()) {
                        bonusBoard[1][cardId][1] = entry.getValue();
                        bonusBoard[1][cardId][0] = player.getId();
                    }

                    if (entry.getValue() > bonusBoard[0][cardId][1]) {
                        bonusBoard[1][cardId][1] = bonusBoard[0][cardId][1];
                        bonusBoard[1][cardId][0] = bonusBoard[0][cardId][0];
                        bonusBoard[0][cardId][1] = entry.getValue();
                        bonusBoard[0][cardId][0] = player.getId();
                    }

                } catch (NullPointerException e) {
                    e.printStackTrace();
                }

            }
        }

        return bonusBoard;
    }

    /**
     * Method that asserts the King's and Queen's bonus.
     * The bonuses will be added to the Coins that each player has.
     * @param bonusBoard -> final int : 3D matrix
     * */
    public void assertKingAndQueen(final int[][][] bonusBoard) {
        for (int i = 0; i < c.getMaxCardsInHands(); ++i) {
            if (bonusBoard[0][i][1] > c.getZero()) {
                players.get(bonusBoard[0][i][0]).addCoins(
                        ((LegalGoods) GoodsFactory.getInstance().getGoodsById(i)).getKingBonus());
            }

            if (bonusBoard[1][i][1] > c.getZero()) {
                players.get(bonusBoard[1][i][0]).addCoins(
                        ((LegalGoods) GoodsFactory.getInstance().getGoodsById(i)).getQueenBonus());
            }
        }
    }

    /**
     * Method that displays the final leaderboard at the end of the game.
     * @param outStream -> PrintStream
     * */
    public void displayFinalScores(final PrintStream outStream) throws IOException {
        PrintStream outputStream = outStream;
        /*
          Sort the players in descending order by the ammount of coins they have.
        */
        Collections.sort(players, new Comparator<Basic>() {
            @Override
            public int compare(final Basic o1, final Basic o2) {
                return o2.getTreasuryCoins() - o1.getTreasuryCoins();
            }
        });

        /*
          Redirect the outStream to the system console
          and print the leaderboard in the required manner.
        */
        outputStream = new PrintStream(System.out);

        for (int i = 0; i < players.size(); ++i) {
            outputStream.println(players.get(i).getId() + " "
                    + playerNames.get(players.get(i).getId()).toUpperCase()
                    + " " + players.get(i).getTreasuryCoins());
        }
    }
}
