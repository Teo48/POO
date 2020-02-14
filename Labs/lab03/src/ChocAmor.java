public class ChocAmor extends CandyBox {
    public float length;

    ChocAmor() {}

    ChocAmor(String flavor, String origin, float length) {
        super(flavor, origin);
        this.length = length;
    }

    @Override
    public float getVolume() {
        return length * length * length;
    }

    @Override
    public String toString() {
        return "The " + this.getOrigin() + " " + this.getFlavor() + " has volume " +
                this.getVolume();
    }

    public void printChocAmorDim() {
        System.out.println("Lungime: " + this.length);
    }
}
