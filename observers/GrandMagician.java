package observers;

/**
 * Singleton class for the GrandMagician.
 * */
public final class GrandMagician implements Observer {
    private static GrandMagician grandMagician = null;

    private GrandMagician() {
    }

    public static GrandMagician getInstance() {
        if (grandMagician == null) {
            return new GrandMagician();
        }

        return grandMagician;
    }

    @Override
    public void update(final String str) {
        System.out.println(str);
    }
}
