public class Complex {
    private int real;
    private int imaginary;

    public Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex() {
        this(0,0 );
    }

    public Complex(Complex c) {
        this.real = c.real;
        this.imaginary = c.imaginary;
    }

    public int getReal() {
        return this.real;
    }

    public int getImaginary() {
        return this.imaginary;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public void addWithComplex(Complex c) {
        this.real += c.real;
        this.imaginary += c.imaginary;
    }
    
    public void showComplex() {
        if (this.imaginary < 0) {
            System.out.println(this.real + "" + this.imaginary + "i");
        } else {
            System.out.println(this.real + " + " + this.imaginary + "i");
        }
    }

}
