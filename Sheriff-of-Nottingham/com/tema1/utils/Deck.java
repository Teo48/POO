package com.tema1.utils;

import com.tema1.goods.Goods;

import java.util.LinkedList;
/**
 * Singleton for the deck of cards.
 * */
public final class Deck {
    private static final Deck DECKOFCARDS = new Deck();
    private LinkedList<Goods> cards;
    /**
     * Constructor that will be called only ONCE generating the DECKOFCARDS object.
     * */
    private Deck() {
        cards = new LinkedList<Goods>();
    }
    /**
     * Method used for adding cards to the initial deck.
     * It will be used later for adding the cards seized by the Sheriff.
     * @param good -> Final Goods
     * */
    public void addCards(final Goods good) {
        cards.add(good);
    }

    /**
     * @return LinkedList<Goods>
     * */
    public LinkedList<Goods> getCards() {
        return cards;
    }

    /**
     * Method used for removing cards from deck when they are distributed.
     * */
    public void removeCards() {
        cards.removeFirst();
    }
    /**
     * @return static Deck
     * */
    public static Deck getInstance() {
        return DECKOFCARDS;
    }
}
