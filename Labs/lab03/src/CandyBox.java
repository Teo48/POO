public class CandyBox {
    private String flavor;
    private String origin;

    public CandyBox() {}

    public CandyBox(String flavor, String origin) {
        this.flavor = flavor;
        this.origin = origin;
    }

    public float getVolume() {
        return 0;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getFlavor() {
        return this.flavor;
    }

    @Override
    public String toString() {
        return flavor + " " + origin;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof CandyBox)) {
            return false;
        }

        return this.origin == ((CandyBox) obj).origin;
    }

    @Override
    public int hashCode() {
        int hash = 7;

        for (int i = 0 ; i < flavor.length() ; ++i) {
            hash = hash * 31 + (int)Math.random() % 61333;
        }

        return hash;
    }
}
