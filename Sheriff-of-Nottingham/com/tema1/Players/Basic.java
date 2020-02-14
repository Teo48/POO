package com.tema1.Players;

import com.tema1.goods.Goods;
import com.tema1.goods.GoodsFactory;
import com.tema1.goods.GoodsType;
import com.tema1.goods.IllegalGoods;
import com.tema1.utils.Constants;
import com.tema1.utils.Deck;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.ArrayList;

/**
 * Class that implements the Basic player.
 * This class can be EXTENDED.
 * Members:
 *  - Map<Goods, Integer> goodsOnStand
 *  - ArrayList<Goods> bag, cardsInHand
 *  - Goods declaredGood
 *  - int id
 *  - int bribe
 *  - int treasuryCoins
 *  - static Constants
 * */
public class Basic {
    private Map<Goods, Integer> goodsOnStand;
    private ArrayList<Goods> bag, cardsInHand;
    private Goods declaredGood;
    private int id;
    private int bribe;
    private int treasuryCoins;
    private static Constants c = new Constants();

    /**
     * Constructor used for initialization of a Basic player.
     * */
    public Basic() {
        goodsOnStand = new HashMap<>();
        bag = new ArrayList<>();
        cardsInHand = new ArrayList<>();
        declaredGood = GoodsFactory.getInstance().getGoodsById(0);
        id = c.getZero();
        bribe = c.getZero();
        treasuryCoins = c.getStartingMoney();
        for (int i = 0; i <= c.getMaxGoodsId(); ++i) {
            goodsOnStand.put(GoodsFactory.getInstance().getGoodsById(i), c.getZero());
        }
    }

    /**
     * Method used for drawing cards from deck.
     * @param deck -> final Deck
     * */
    public final void drawCards(final Deck deck) {
        LinkedList<Goods> cards = deck.getCards();
        if (cardsInHand.size() != c.getZero()) {
            cardsInHand.clear();
        }

        for (int i = 0; i < c.getMaxCardsInHands(); ++i) {
            cardsInHand.add(cards.peek());
            try {
                deck.removeCards();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method used for asserting a penalty when the Basic player is being checked by the Sheriff.
     * If he is a liar he loses all the goods he had in his bag and he also pays a penalty.
     * Otherwise, the Sheriff has to pay the penalty to the Basic player.
     * */
    public final void getPenalty(final Deck deck,
                                              final Basic player) {
        boolean isLiar = false;
        LinkedList<Goods> cardsToRemove = new LinkedList<>();
        int penalty = c.getZero();

        if (player.getBag().size() != c.getZero()) {
            for (Goods card : player.getBag()) {
                if ((player.getDeclaredCard() != card) || card.getType() == GoodsType.Illegal) {
                    penalty += card.getPenalty();
                    deck.addCards(card);
                    cardsToRemove.add(card);
                    isLiar = true;
                }
            }
        }

        player.getBag().removeAll(cardsToRemove);

        if (!isLiar) {
            for (Goods card : player.getBag()) {
                penalty -= card.getPenalty();
            }
        }

        treasuryCoins += penalty;
        player.addCoins(-penalty);

    }

    /**
     * Method that puts the good a player has to the stand.
     * */
    public final void takeGoodsToStand() {

        for (Goods card : getBag()) {
            switch (card.getType()) {
                case Illegal:
                        goodsOnStand.put(card, goodsOnStand.get(card) + 1);
                        for (Map.Entry<Goods, Integer> entry
                                : ((IllegalGoods) card).getIllegalBonus().entrySet()) {
                            for (int i = 0; i < entry.getValue(); ++i) {
                                goodsOnStand.put(entry.getKey(),
                                        goodsOnStand.get(entry.getKey()) + 1);
                            }
                        }

                    break;
                case Legal:
                    goodsOnStand.put(card, goodsOnStand.get(card) + 1);
                    break;
                default: break;
            }
        }

        getBag().clear();
    }
    /**
     * Method used when a player plays as merchant based on the rules a Basic player has to follow.
     * This method can be OVERRIDEN.
     * */
    public void playMerchant() {
        final int appleCard = 0;
        playLegal();

        if (getBag().isEmpty()) {
            playIllegal();
            setDeclaredGood(GoodsFactory.getInstance().getGoodsById(appleCard));
        }
    }
    /**
     * Method used when a players plays as sheriff based on the rules a Basic player has to follow.
     * This method can be OVERRIDEN.
     * @param deck -> final Deck
     * @param players -> LinkedList<Basic>
     * */
    public void playSheriff(final Deck deck,
                                         final LinkedList<Basic> players) {
        for (Basic player : players) {
            if (!player.equals(this) && getTreasuryCoins() >= c.getMinimumMoney()) {
                getPenalty(deck, player);
                player.takeGoodsToStand();
            }
        }
    }

    /**
     * Method used when a player has to play legal.
     * This method can be OVERRIDDEN.
     * */
    public void playLegal() {
        HashMap<Integer, Integer> cardsFrequency = new HashMap<Integer, Integer>();

        for (int i = 0; i < c.getMaxGoodsId(); ++i) {
            cardsFrequency.put(i, c.getZero());
        }

        int maximumFrequency = Integer.MIN_VALUE;

        for (Goods card : getCardsInHand()) {
            try {
                if (card.getType() == GoodsType.Legal) {
                    int cardId = card.getId();
                    cardsFrequency.put(cardId, cardsFrequency.get(cardId) + 1);

                    if (cardsFrequency.get(cardId) > maximumFrequency) {
                        maximumFrequency = cardsFrequency.get(cardId);
                        setDeclaredGood(card);
                    } else if (card.getProfit() > getDeclaredCard().getProfit()
                            && cardsFrequency.get(cardId) == maximumFrequency) {
                        setDeclaredGood(card);
                    }
                }

                if (card.getType() == GoodsType.Legal
                        && getDeclaredCard().getProfit() == card.getProfit()
                        && card.getId() > getDeclaredCard().getId()
                        && cardsFrequency.get(card.getId()) == maximumFrequency) {
                    setDeclaredGood(card);
                }

            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }


        for (Goods card : getCardsInHand()) {
            try {
                if (getBag().size() < c.getMaxItemBag()
                        && card.getId() == getDeclaredCard().getId()) {
                    getBag().add(card);
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Method used when a player has to play illegal.
     * This method can be OVERRIDEN.
     * */
    public void playIllegal() {
        int maximumProfit = Integer.MIN_VALUE;
        int maxId = c.getNil();

        for (Goods card : getCardsInHand()) {
            if (card.getType() == GoodsType.Illegal && getTreasuryCoins()
                    >= c.getIllegalPenalty() && card.getProfit() > maximumProfit) {
                maxId = card.getId();
                maximumProfit = card.getProfit();
            }
        }

        for (Goods card : getCardsInHand()) {
            if (maxId == card.getId()) {
                getCardsInHand().remove(card);
                break;
            }
        }

        if (maxId != c.getNil()) {
            getBag().add(GoodsFactory.getInstance().getGoodsById(maxId));
        }


    }

    /*
      Required getters & setters.
     */
    public final Goods getDeclaredCard() {
        return this.declaredGood;
    }

    public final int getTreasuryCoins() {
        return this.treasuryCoins;
    }
    public final boolean hasBribe() {
        return this.bribe > 0;
    }

    public final void setBribe(final int value) {
        this.bribe = value;
    }

    public final void receiveBribe(final int value) {
        this.treasuryCoins += value;
    }

    public final int payBribe() {
        this.treasuryCoins -= bribe;
        return bribe;
    }

    public final void addCoins(final int value) {
        this.treasuryCoins += value;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final int getId() {
        return this.id;
    }

    public final void setDeclaredGood(final Goods card) {
        this.declaredGood = card;
    }

    public final Map<Goods, Integer> getGoodsOnStand() {
        return this.goodsOnStand;
    }

    public final ArrayList<Goods> getBag() {
        return this.bag;
    }

    public final ArrayList<Goods> getCardsInHand() {
        return this.cardsInHand;
    }
}

