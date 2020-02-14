public class TestSingleton {
    public static void main(String [] args) {
        PasswordMakerSingleton p = PasswordMakerSingleton.getInstance();
        System.out.println(p.counter);
        PasswordMakerSingleton p1 = PasswordMakerSingleton.getInstance();
        System.out.println(p1.counter);
        PasswordMakerSingleton p2 = PasswordMakerSingleton.getInstance();
        System.out.println(p2.counter);
        System.out.println(p.getPassowrd("gigel"));
    }
}
