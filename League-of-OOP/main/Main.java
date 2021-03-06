package main;

import angels.Angel;
import angels.AngelsFactory;
import exceptions.InvalidAngelException;
import exceptions.InvalidLandException;
import exceptions.InvalidMoveException;
import exceptions.InvalidPlayerException;
import players.Hero;
import players.HeroFactory;
import utils.Coordinates;
import observers.GrandMagician;
import utils.Map;
import utils.Reader;
import observers.Observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public final class Main {
    private Main() {
    }

    /**
     * Reads the input data from args[0] using an instance of Reader.
     * Opens a PrintStream from args[1] and redirects the output to the Sys.Console.
     * Creates an ArrayList with all the players in the current game.
     * Stores an array with all the movements players are going to execute.
     * Creates an ArrayList with all the angels in the current game and then the game starts.
     * */
    public static void main(final String[] args) throws IOException, InvalidMoveException {
        int n, m;
        Reader reader = new Reader(args[0]);
        PrintStream printStream = new PrintStream(new File(args[1]));
        System.setOut(printStream);

        n = reader.nextInt();
        m = reader.nextInt();

        Map map = Map.getInstance();

        String[] land = new String[n + 1];
        for (int i = 0; i < n; ++i) {
            land[i] = reader.readLine();
        }

        try {
            map.createMap(land, n, m);
        } catch (InvalidLandException e) {
            e.printStackTrace();
        }

        GrandMagician grandMagician = GrandMagician.getInstance();
        int nrPlayers = reader.nextInt();

        String junk;
        ArrayList<Hero> heroes = new ArrayList<>();

        for (int i = 0; i < nrPlayers; ++i) {
            junk = reader.readLine();
            String[] info = junk.split("\\s+");
            try {
                heroes.add(HeroFactory.getHeroes(info[0], new Coordinates(Integer.parseInt(info[1]),
                        Integer.parseInt(info[2]))));
                heroes.get(i).setId(i);
                heroes.get(i).addObserver(grandMagician);
            } catch (InvalidPlayerException e) {
                e.printStackTrace();
            }
        }

        int nrRounds = reader.nextInt();
        String[] moves = new String[nrRounds];
        for (int i = 0; i < nrRounds; ++i) {
            moves[i] = reader.readLine();
        }
        int nrAngelsCurrentRound;
        String dummy;
        ArrayList<ArrayList<Angel>> angels = new ArrayList<>();
        ArrayList<Integer> nrAngelsPerRound = new ArrayList<>();
        for (int i = 0; i < nrRounds; ++i) {
            nrAngelsCurrentRound = reader.nextInt();
            nrAngelsPerRound.add(nrAngelsCurrentRound);
            if (nrAngelsCurrentRound == 0) {
                continue;
            }
            dummy = reader.readLine();
            String[] info = dummy.split("\\s+");

            ArrayList<Angel> currentRoundsAngels = new ArrayList<>();
            for (int j = 0; j < nrAngelsCurrentRound; ++j) {
                String[] garbage = info[j].split(",");
                try {
                    currentRoundsAngels.add(AngelsFactory.getAngels(garbage[0],
                            new Coordinates(Integer.parseInt(garbage[1]),
                        Integer.parseInt(garbage[2]))));
                } catch (InvalidAngelException e) {
                    e.printStackTrace();
                }
            }
            angels.add(currentRoundsAngels);
        }

        playGame(angels, heroes, nrAngelsPerRound, moves, nrRounds, grandMagician);
        System.out.println("~~ Results ~~");
        for (Hero h : heroes) {
            System.out.println(h);
        }

        printStream.close();
    }

    /**
     * Method used for the fight between two players.
     * @param heroes
     * @param j
     * @param k
     * */
    private static void fight(final ArrayList<Hero> heroes, final int j, final int k) {
        heroes.get(k).accept(heroes.get(j).heroSkill());
        heroes.get(j).accept(heroes.get(k).heroSkill());
    }

    /**
     * Method used for xp gaining for the winning player.
     * @param heroes
     * @param j
     * @param k
     * */
    private static void gainPoints(final ArrayList<Hero> heroes, final int j, final int k) {
        if (!heroes.get(j).isDead() && heroes.get(k).isDead()) {
            showKilledPlayers(heroes, k, j);
            heroes.get(j).gainXp(heroes.get(k).getLevel());
        }
    }

    /**
     * Method used for notifying the GrandMagician when a player is killed.
     * @param heroes
     * @param k
     * @param j
     * */
    private static void showKilledPlayers(final ArrayList<Hero> heroes, final int k, final int j) {
        StringBuilder sb = new StringBuilder();
        sb.append("Player ").append(heroes.get(k).getClass().getSimpleName()).append(" ")
                .append(heroes.get(k).getId()).append(" was killed by ")
                .append(heroes.get(j).getClass().getSimpleName()).append(" ")
                .append(heroes.get(j).getId());
        heroes.get(k).notifyObserver(sb.toString());
    }

    /**
     * Method used to apply angels' effects at the end of each round.
     * The grandMagician is notified when an angel is spawned.
     * An angel visits a player if they are on the same cell.
     * @param angels
     * @param heroes
     * @param counter
     * @param grandMagician
     * */
    private static void applyAngelsEffects(final ArrayList<ArrayList<Angel>> angels,
                                           final ArrayList<Hero> heroes, final int counter,
                                           final Observer grandMagician) {
        for (int j = 0; j < angels.get(counter).size(); ++j) {
            angels.get(counter).get(j).addObserver(grandMagician);
            StringBuilder sb = new StringBuilder();
            sb.append("Angel ").append(angels.get(counter).get(j).getClass().getSimpleName())
                    .append(" was spawned at ").append(angels.get(counter).get(j)
                    .getCoordinates().getX()).append(" ").append(angels.get(counter).get(j)
                    .getCoordinates().getY());
            angels.get(counter).get(j).notifyObserver(sb.toString());

            for (int k = 0; k < heroes.size(); ++k) {
                if (angels.get(counter).get(j).getCoordinates()
                        .equals(heroes.get(k).getCoordinates())) {
                    heroes.get(k).acceptAngel(angels.get(counter).get(j));
                }
            }
        }
    }

    /**
     * Game's logic.
     * At the start of each round we apply the passive damage to each player.
     * If the hero is not dead or stunned he picks a strategy based on his HP.
     * After that the movements are executed and if there are two or more players on the same
     * cell, they fight.
     * @param angels
     * @param heroes
     * @param nrAngelsPerRound
     * @param moves
     * @param nrRounds
     * @param grandMagician
     * */
    private static void playGame(final ArrayList<ArrayList<Angel>> angels,
                                 final ArrayList<Hero> heroes,
                                 final ArrayList<Integer> nrAngelsPerRound, final String[] moves,
                                 final int nrRounds, final Observer grandMagician)
            throws InvalidMoveException {
        int cnt = 0;
        for (int i = 0; i < nrRounds; ++i) {
            StringBuilder sb = new StringBuilder();
            sb.append("~~ Round ").append(i + 1).append(" ~~");
            System.out.println(sb.toString());

            for (Hero h : heroes) {
                if (h.isDead()) {
                    continue;
                }

                h.getPassiveDamage();
            }

            for (int j = 0; j < heroes.size(); ++j) {
                if (heroes.get(j).isDead()) {
                    continue;
                }


                if (heroes.get(j).getStunnedTurns() < 1) {
                    heroes.get(j).pickStrategy();
                }

                switch (moves[i].charAt(j)) {
                    case 'U':
                        heroes.get(j).move(-1, 0);
                        break;
                    case 'D':
                        heroes.get(j).move(1, 0);
                        break;
                    case 'R':
                        heroes.get(j).move(0, 1);
                        break;
                    case 'L':
                        heroes.get(j).move(0, -1);
                        break;
                    case '_':
                        heroes.get(j).move(0, 0);
                        break;
                    default:
                        throw new InvalidMoveException("Invalid move!");
                }

            }

            /*
             * If both players are alive and they are on the same cell they fight.
             * */
            for (int j = 0; j < heroes.size() - 1; ++j) {
                for (int k = j + 1; k < heroes.size(); ++k) {
                    if (!heroes.get(j).isDead() && !heroes.get(k).isDead()) {
                        if (heroes.get(j).getCoordinates().equals(heroes.get(k).getCoordinates())) {
                            if (heroes.get(k).getClass().getSimpleName().charAt(0) == 'R') {
                                fight(heroes, j, k);
                            } else {
                                fight(heroes, k, j);
                            }
                            gainPoints(heroes, j, k);
                            gainPoints(heroes, k, j);
                            if (heroes.get(j).isDead() && heroes.get(k).isDead()) {
                                showKilledPlayers(heroes, k, j);
                                showKilledPlayers(heroes, j, k);
                                int firstPlayerLevel = heroes.get(k).getLevel();
                                int secondPlayerLevel = heroes.get(j).getLevel();
                                heroes.get(j).gainXp(firstPlayerLevel);
                                heroes.get(k).gainXp(secondPlayerLevel);
                            }
                        }
                    }
                }
            }

            if (nrAngelsPerRound.get(i) != 0) {
                applyAngelsEffects(angels, heroes, cnt, grandMagician);
                ++cnt;
            }

            System.out.println(" ");
        }
    }
}
