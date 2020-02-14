package ex1Task3;

interface Engine {
    public int getFuelCapacity();
}

class Car {
    public Engine getEngine(int fuelCapacity) {
        if (fuelCapacity == 11) {
            class OttoEngine implements Engine {
                private int fuelCapacity = 11;

                public int getFuelCapacity() {
                    return fuelCapacity;
                }
            }

            return new OttoEngine();
        }

        return null;
    }
}

public class Test {
    public static void main(String[] args) {

        Engine firstEngine = new Car().getEngine(11);
        System.out.println(firstEngine.getFuelCapacity());
//        System.out.println(secondEngine.getFuelCapacity());
    }
}