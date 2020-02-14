package com.tema1.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tema1.utils.Reader;
import fileio.FileSystem;

public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() throws IOException {
        List<Integer> assetsIds = new ArrayList<>();
        List<String> playerOrder = new ArrayList<>();
        int rounds = 0;
        int noPlayers, noGoods;

        Reader reader = new Reader(mInputPath);

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);
            rounds = reader.nextInt();
            noPlayers = reader.nextInt();
            String line = reader.readLine();

            String[] junk = line.split("\\s+");

            for (int i = 0; i < noPlayers; ++i) {
                playerOrder.add(junk[i]);
            }

            noGoods = reader.nextInt();

            for (int i = 0; i < noGoods; ++i) {
                assetsIds.add(reader.nextInt());
            }

            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(rounds, assetsIds, playerOrder);
    }
}
