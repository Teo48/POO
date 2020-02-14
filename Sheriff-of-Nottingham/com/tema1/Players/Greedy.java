package com.tema1.Players;

import com.tema1.utils.Constants;
import com.tema1.utils.Deck;

import java.util.LinkedList;

/**
 * Class that implements the Greedy player which is extended from Basic.
 * This class CANNOT be extended.
 * Members:
 *  - static int roundNumber
 *  - static Constants
 * */
public final class Greedy extends Basic {
    private static int roundNumber;
    private static Constants c = new Constants();
    /**
     * Constructor used for initializing the roundNumber with 0.
     * */
    public Greedy() {
        roundNumber = c.getZero();
    }

    public void increaseRoundNumber() {
        ++roundNumber;
    }

    /**
     * Overriden method for a Bribe player based on the rules he has to follow as a merchant.
     * */
    @Override
    public void playSheriff(final Deck deck,
                                         final LinkedList<Basic> players) {
        for (Basic player : players) {
            if (!player.equals(this)) {
                if (!player.hasBribe() && getTreasuryCoins() >= c.getMinimumMoney()) {
                    getPenalty(deck, player);
                } else {
                    receiveBribe(player.payBribe());
                }

                player.takeGoodsToStand();
            }
        }
    }

    /**
     * Overriden method for a Greedy player based on the rules he has to follow as a merchant.
     * */
    @Override
    public void playMerchant() {
        super.playMerchant();

        if ((roundNumber & 1) == 0 && getBag().size() < c.getMaxItemBag()) {
            playIllegal();
        }
    }
}
