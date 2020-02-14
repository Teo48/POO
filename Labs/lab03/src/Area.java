public class Area {
    public CandyBag cb;
    public int number;
    public String street;

    Area() {}

    Area(CandyBag cb, int number, String street) {
        this.cb = cb;
        this.number = number;
        this.street = street;
    }

    public void getBirthdayCard() {
        System.out.println(this.street + " " + this.number);
        System.out.println("La multi ani!");

        for (CandyBox element : cb.gift) {
            System.out.println(element);

//            if (element instanceof Lindt) {
//                System.out.println("E un lindt, boss!");
//                continue;
//            }
//
//            if (element instanceof Baravelli) {
//                System.out.println("E un baravelli, boss!");
//                continue;
//            }
//
//            if (element instanceof ChocAmor) {
//                System.out.println("E un chocamor, boss!");
//                continue;
//            }

            /*
             * Fara instanceof
             */

            if (element.getClass().equals(Lindt.class)) {
                System.out.println("E un lindt, boss!");
                continue;
            }

            if (element.getClass().equals(Baravelli.class)) {
                System.out.println("E un baravelli, boss!");
                continue;
            }

            if (element.getClass().equals(ChocAmor.class)) {
                System.out.println("E un chocamor, boss!");
                continue;
            }

        }
    }
}
