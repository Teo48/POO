package com.tema1.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) throws IOException {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        SheriffOfNottingham game = new SheriffOfNottingham();
        game.getGameReady(gameInputLoader.load());
        game.playGame();
        game.computeScore();
        int[][][] bonusBoard = game.computeBonuses();
        game.assertKingAndQueen(bonusBoard);
        PrintStream outStream = new PrintStream(new FileOutputStream(args[1]));
        game.displayFinalScores(outStream);
    }
}
