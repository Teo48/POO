package utils;

/**
 * Singelton class for the map.
 * */

public final class Map {
    private LandType[][] landTypes;
    private static final Map MAP = new Map();

    private Map() {
        landTypes = new LandType[0][0];
    }

    /**
     * Method that asserts each cell a specific land type.
     * @param land -> String array.
     * @param n -> map lenght.
     * @param m -> map width.
     * */
    public void createMap(final String[] land, final int n, final int m) {
        landTypes = new LandType[n + 1][m + 1];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                switch (land[i].charAt(j)) {
                    case 'V':
                        landTypes[i][j] = LandType.VOLCANIC;
                        break;
                    case 'L':
                        landTypes[i][j] = LandType.LAND;
                        break;
                    case 'W':
                        landTypes[i][j] = LandType.WOODS;
                        break;
                    case 'D':
                        landTypes[i][j] = LandType.DESERT;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public LandType getLandType(final int n, final int m) {
        return landTypes[n][m];
    }

    public static Map getInstance() {
        if (MAP == null) {
            new Map();
        }

        return MAP;
    }
}
