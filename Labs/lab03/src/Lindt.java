public class Lindt extends CandyBox {
    public float length, width, height;

    public Lindt() {}

    public Lindt(String flavor, String origin, float length, float width, float height) {
        super(flavor, origin);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public float getVolume() {
        return length * width * height;
    }

    @Override
    public String toString() {
        return "The " + this.getOrigin() + " " + this.getFlavor() + " has volume " +
                this.getVolume();
    }

    public void printLindtDim() {
        System.out.println("Lungime: " + this.length + " " + "Latime: " + this.width + " " +
                "Inaltime: " + this.height);
    }
}
