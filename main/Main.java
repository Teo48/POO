package main;

import exceptions.InvalidMoveException;
import exceptions.InvalidPlayerException;
import players.Hero;
import players.HeroFactory;
import utils.Coordinates;
import utils.Map;
import utils.Reader;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public final class Main {
    private Main() {
    }

    /**
     * Reads the input data from args[0] using an instance of Reader.
     * Creats an array of heroes and then the game starts.
     * */
    public static void main(final String[] args) throws IOException, InvalidMoveException {
        int n, m;
        Reader reader = new Reader(args[0]);

        n = reader.nextInt();
        m = reader.nextInt();

        String[] land = new String[n + 1];
        for (int i = 0; i < n; ++i) {
            land[i] = reader.readLine();
        }


        Map map = Map.getInstance();
        map.createMap(land, n, m);
        int nrPlayers = reader.nextInt();

        String junk;
        ArrayList<Hero> heroes = new ArrayList<>();

        for (int i = 0; i < nrPlayers; ++i) {
            junk = reader.readLine();
            String[] info = junk.split("\\s+");
            try {
                heroes.add(HeroFactory.getHeroes(info[0], new Coordinates(Integer.parseInt(info[1]),
                        Integer.parseInt(info[2]))));
            } catch (InvalidPlayerException e) {
                e.printStackTrace();
            }
        }

        int nrRounds = reader.nextInt();

        String[] moves = new String[nrRounds];
        for (int i = 0; i < nrRounds; ++i) {
            moves[i] = reader.readLine();
            for (int j = 0; j < heroes.size(); ++j) {
                if (heroes.get(j).isDead()) {
                    continue;
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

            if (i != 0) {
                for (Hero h : heroes) {
                    h.getPassiveDamage();
                }
            }

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
                        }
                    }
                }
            }
        }

        PrintStream printStream = new PrintStream(new File(args[1]));

        for (Hero h : heroes) {
            printStream.println(h);
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
            heroes.get(j).gainXp(heroes.get(k).getLevel());
        }
    }
}
