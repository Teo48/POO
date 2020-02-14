package ex1Task1;

interface Engine {
    int getFuelCapacity();
}

class Car {
    public Engine getEngine(int fuelCapacitys) {
        return new Engine () {
            //private int fuelCapacity = fuelCapacitys;

            public int getFuelCapacity() {
                return fuelCapacitys;
            }
        };
    }

    public class Gigel {
    }
}

public class task1 {
    public static void main(String[] args) {
        System.out.println(new Car().getEngine(10).getFuelCapacity());
    }
}