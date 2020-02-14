package com.tema1.Players;
/**
 * Class which returns a new basic based on the value of String from the Constructor.
 * */
public abstract class PlayersFactory {
    /**
     * @param name -> final String
     * @return static Basic
     * */
    public static Basic getPlayer(final String name) {
        switch (name) {
            case "basic":
                return new Basic();
            case "greedy":
                return new Greedy();
            case "bribed":
                return new Bribed();
            default:
                return null;
        }
    }
}
