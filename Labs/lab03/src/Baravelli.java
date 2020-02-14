public class Baravelli extends CandyBox {
    public float radius, height;

    Baravelli() {
    }

    Baravelli(String flavor, String origin, float radius, float height) {
        super(flavor, origin);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public float getVolume() {
        return (float) Math.PI * radius * radius * height;
    }

    @Override
    public String toString() {
        return "The " + this.getOrigin() + " " + this.getFlavor() + " has volume " +
                this.getVolume();
    }

    public void printBaravelliDim() {
        System.out.println("Raza: " + this.radius + " " + "Inaltimea: " + this.height);
    }
}