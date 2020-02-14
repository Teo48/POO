package ex1Task2;

interface Engine {
    public int getFuelCapacity();
}

class Car {
    private class OttoEngine implements Engine {
        private int fuelCapacity;

        public OttoEngine(int fuelCapacity) {
            this.fuelCapacity = fuelCapacity;
        }

        public int getFuelCapacity() {
            return fuelCapacity;
        }
    }

    public OttoEngine getEngine() {
        OttoEngine engine = new OttoEngine(11);
        return engine;
    }
}

public class Test {
    public static void main(String[] args) {
        Car car = new Car();

//        Car.OttoEngine firstEngine = car.getEngine();
//        Car.OttoEngine secondEngine = new Car.OttoEngine(3);

//        Car firstEngine = car.getEngine();
        Engine e = car.getEngine();
        System.out.println(e.getFuelCapacity());
        //System.out.println(secondEngine.getFuelCapacity());
    }
}