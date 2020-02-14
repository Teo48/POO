import org.apache.commons.text.RandomStringGenerator;

import java.util.Random;

import static org.apache.commons.text.CharacterPredicates.DIGITS;
import static org.apache.commons.text.CharacterPredicates.LETTERS;

public class PasswordMakerSingleton {
    private static final int MAGIC_NUMBER = 13;

    private static RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0', 'z')
            .filteredBy(LETTERS, DIGITS).build();

    private static final String MAGIC_STRING = generator.generate(new Random().ints(20, 100)
            .findFirst().getAsInt());
    /**
     *  Singleton - Eager Initialization
     * */
//    private static final PasswordMakerSingleton instance = new PasswordMakerSingleton();
//
//    private PasswordMakerSingleton() {}
//
//    public static PasswordMakerSingleton getInstance() {
//        return instance;
//    }

    /**
     * Singleton - Static Initialization
     * */

    private static PasswordMakerSingleton instance;

    private PasswordMakerSingleton() {}

    static {
        try {
            instance = new PasswordMakerSingleton();
        } catch (Exception e) {
            System.exit(-1);
        }
    }

    public static int counter = 0;

    public static PasswordMakerSingleton getInstance() {
        ++counter;
        return instance;
    }

    public String getPassowrd(String name) {
        char [] alphabet = new char[10];

        for (int i = 0 ; i < 10 ; ++i) {
            alphabet[i] = MAGIC_STRING.charAt(new Random().nextInt(Integer.MAX_VALUE) % MAGIC_STRING.length());
        }

        RandomStringGenerator smartGenerator = new RandomStringGenerator.Builder().selectFrom(alphabet).build();
        String firstPass = smartGenerator.generate(MAGIC_NUMBER);

        String password = firstPass + name.length() + new Random().nextInt(101);

        return password;
    }
}
