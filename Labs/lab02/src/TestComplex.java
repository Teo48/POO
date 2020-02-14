public class TestComplex {
    public static void main(String [] args) {
        Complex c1 = new Complex(1, 2);
        Complex c2 = new Complex(10, -4);
        c1.addWithComplex(c2);
        c1.showComplex();
    }
}
