import org.apache.commons.text.RandomStringGenerator;

import java.util.Random;

import static org.apache.commons.text.CharacterPredicates.DIGITS;
import static org.apache.commons.text.CharacterPredicates.LETTERS;

public class PasswordMaker {
    private static final int MAGIC_NUMBER = 13;
    private static RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0', 'z')
            .filteredBy(LETTERS, DIGITS).build();

    private static final String MAGIC_STRING = generator.generate(new Random().ints(20, 100)
            .findFirst().getAsInt());

    private String name;

    public PasswordMaker(String name) {
        this.name = name;
    }
    
    public String getPassowrd() {
        char [] alphabet = new char[10];

        for (int i = 0 ; i < 10 ; ++i) {
            alphabet[i] = MAGIC_STRING.charAt(new Random().nextInt(Integer.MAX_VALUE) % MAGIC_STRING.length());
        }

        RandomStringGenerator smartGenerator = new RandomStringGenerator.Builder().selectFrom(alphabet).build();
        String firstPass = smartGenerator.generate(MAGIC_NUMBER);

        String password = firstPass + name.length() + new Random().nextInt(101);

        return password;
    }

    public static void main(String [] args) {
        PasswordMaker p = new PasswordMaker("gigel");
        System.out.println(p.getPassowrd());
    }
}
