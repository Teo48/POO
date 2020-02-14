package observers;

/**
 * Singleton class for the GrandMagician.
 * */
public final class GrandMagician implements Observer {
    private static volatile GrandMagician grandMagician = null;

    private GrandMagician() {
    }

    @Override
    public void update(final String str) {
        System.out.println(str);
    }

    public static GrandMagician getInstance() {
        if (grandMagician == null) {
            synchronized (GrandMagician.class) {
                if (grandMagician == null) {
                    return new GrandMagician();
                }
            }
        }

        return grandMagician;
    }

}
