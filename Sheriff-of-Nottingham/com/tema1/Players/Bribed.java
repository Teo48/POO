package com.tema1.Players;

import com.tema1.goods.Goods;
import com.tema1.goods.GoodsFactory;
import com.tema1.utils.Constants;
import com.tema1.utils.Deck;
import com.tema1.utils.GoodsComparator;
import com.tema1.utils.Pair;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Class that implements the Bribed player which is extended from Basic.
 * This class CANNOT be extended.
 * Members:
 *  - static Pair<LinkedList<Goods>, LinkedList<Goods>>
 *  - static Constants
 *  - Basic leftPlayer
 *  - Basic rightPlayer
 * */
public final class Bribed extends Basic {
    private static Pair<LinkedList<Goods>, LinkedList<Goods>> hand
            = new Pair(new LinkedList<>(), new LinkedList<>());
    private static Constants c = new Constants();
    private final int appleCARD = 0;
    private Basic leftPlayer = null;
    private Basic rightPlayer = null;

    public Pair<LinkedList<Goods>, LinkedList<Goods>> getHand() {
        return this.hand;
    }

    /**
     * Utility method used by the Bribe player when he has to play as merchant.
     * */
    public void playBribe() {
        int firstSize = hand.getFirst().size();
        int secondSize = hand.getSecond().size();
        int availableSum = getTreasuryCoins();
        int maximumAllowedIllegals = getTreasuryCoins() / c.getIllegalPenalty();

        if (availableSum - maximumAllowedIllegals * c.getIllegalPenalty()
                == c.getZero()) {
            --maximumAllowedIllegals;
        }

        int minToAdd = Math.min(maximumAllowedIllegals, secondSize);
        for (int i = 0; i < minToAdd && getBag().size() < c.getMaxItemBag(); ++i) {
            getBag().add(hand.getSecond().get(i));
        }

        availableSum -= c.getIllegalPenalty() * minToAdd;
        int maximumAllowedLegals = availableSum / c.getMinimumNumberOfPlayers();
        if (availableSum - c.getMinimumNumberOfPlayers() * maximumAllowedLegals
                == c.getZero()) {
            --maximumAllowedLegals;
        }

        minToAdd = Math.min(maximumAllowedLegals, firstSize);
        for (int i = 0; i < minToAdd && getBag().size() < c.getMaxItemBag(); ++i) {
            getBag().add(hand.getFirst().get(i));
        }
    }

    /**
     * Overriden method for a Bribe player based on the rules he has to follow as a merchant.
     * */
    @Override
    public void playMerchant() {
        for (Goods card : getCardsInHand()) {
            switch (card.getType()) {
                case Illegal:
                    hand.getSecond().add(card);
                    break;
                case Legal:
                    hand.getFirst().add(card);
                    break;
                default:
                    break;
            }
        }


        Collections.sort(hand.getFirst(), new GoodsComparator());
        Collections.sort(hand.getSecond(), new GoodsComparator());

        int availableSum = getTreasuryCoins();
        int secondSize = hand.getSecond().size();

        if (getTreasuryCoins() > c.getMinimumbribevalue() && secondSize
                != c.getZero()) {
            int maximumAllowedIllegals = getTreasuryCoins() / c.getIllegalPenalty();

            if (availableSum - maximumAllowedIllegals * c.getIllegalPenalty()
                    == c.getZero()) {
                --maximumAllowedIllegals;
            }

            if (getTreasuryCoins() >= c.getMaximumbribevalue() && secondSize
                    > c.getMinimumNumberOfPlayers() &&  maximumAllowedIllegals
                    > c.getMinimumNumberOfPlayers()) {
                playBribe();
                setBribe(c.getMaximumbribevalue());
            } else {
                playBribe();
                setBribe(c.getMinimumbribevalue());
            }

            setDeclaredGood(GoodsFactory.getInstance().getGoodsById(appleCARD));
        } else {
            super.playMerchant();
            setBribe(c.getZero());
        }

        hand.getSecond().clear();
        hand.getFirst().clear();
    }



    @Override
    /**
     * Overriden method for a Bribe player based on the rules he has to follow as a sheriff.
     * */
    public void playSheriff(final Deck deck,
                                         final LinkedList<Basic> players) {
        int playersSize = players.size();
        if (rightPlayer == null) {
            int playerAt = 0;
            for (int i = 0; i < playersSize; ++i) {
                if (players.get(i).equals(this)) {
                    playerAt = i;
                    break;
                }
            }

            if (playersSize != c.getMinimumNumberOfPlayers()) {
                rightPlayer = players.get((playerAt + c.getOne()) % playersSize);
                if (playerAt == c.getZero()) {
                    leftPlayer = players.get(playersSize - c.getOne());
                } else {
                    leftPlayer = players.get((--playerAt) % playersSize);
                }
            } else {
                switch (playerAt) {
                    case 0:
                        leftPlayer = players.get(c.getOne());
                        rightPlayer = players.get(c.getOne());
                        break;
                    case 1:
                        leftPlayer = players.get(c.getZero());
                        rightPlayer = players.get(c.getZero());
                        break;
                    default:
                        break;
                }
            }
        }

        if (!rightPlayer.equals(leftPlayer)) {
            if (c.getMinimumMoney() <= getTreasuryCoins()) {
                getPenalty(deck, rightPlayer);
                getPenalty(deck, leftPlayer);
            }

            rightPlayer.takeGoodsToStand();
            leftPlayer.takeGoodsToStand();
        } else {
            if (c.getMinimumMoney() <= getTreasuryCoins()) {
                getPenalty(deck, rightPlayer);
            }
            rightPlayer.takeGoodsToStand();
        }

        for (Basic player : players) {
            if (!player.equals(this) && !player.equals(rightPlayer) && !player.equals(leftPlayer)) {
                if (player.hasBribe()) {
                    receiveBribe(player.payBribe());
                }

                player.takeGoodsToStand();
            }
        }
    }
}
