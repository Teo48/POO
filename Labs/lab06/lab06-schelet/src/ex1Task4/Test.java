package ex1Task4;

class Car {
    class Engine {
        public void getFuelCapacity() {
            System.out.println("I am a generic Engine");
        }
    }
}

class OttoEngine extends Car.Engine {

    OttoEngine(Car car) { // OK
        car.super();
    }
}

public class Test {
    public static void main(String[] args) {
        Car car = new Car();
        OttoEngine ottoEngine = new OttoEngine(car);
        ottoEngine.getFuelCapacity();
    }
}