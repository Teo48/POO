package ex2;

public class Showroom {
    public static void main(String[] args) {

        /* Innocent example to make sure the code runs */
        Dealership dealership = new Dealership(300, 100000);
        Car car1 = dealership.getCar(CarType.GENERIC);
        Car car2 = dealership.getCar(CarType.ELECTRIC_ANON);
        Car car3 = dealership.getCar(CarType.ELECTRIC_LAMBDA);
        Car car4 = dealership.getCar(CarType.SPORTS);

        /**
         * Ferrari nu e privata si ii putem altera continutul.
            Car c5 = dealership.new Ferrari() {
                @Override
                public String showPresentation() {
                    return "Gigel e b0$$";
                }
            };
            System.out.println(c5.showPresentation();

            Car c6 = dealership.new Audi()
        */

        /**
         TODO 3 -> Ferrari e acum o clasa statica
             Car c5 = new Dealership.Ferrari();
             System.out.println(c5.showPresentation());
        */

        dealership.showCars();
        /* TODO 2,3,4: Test all changes to the code */
    }
}
