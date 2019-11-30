package utils;

public class Map {
    private LandType[][] landTypes;
    private static final Map map = new Map();

    private Map() {
        landTypes = new LandType[0][0];
    }

    public void createMap(String[] land, int n, int m) {
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

    public LandType getLandType(int n, int m) {
        return landTypes[n][m];
    }

    public static Map getInstance() {
        if (map == null) {
            new Map();
        }

        return map;
    }
}
