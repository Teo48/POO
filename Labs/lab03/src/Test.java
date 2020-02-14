import java.util.*;

public class Test {
    public static void main(String [] args) {
        CandyBag cb = new CandyBag();
        cb.gift = new ArrayList<>();

        Lindt l1 = new Lindt("asdf", "Romania", 1.2f, 1.3f, 1.5f);
        cb.gift.add(l1);

        Baravelli b1 = new Baravelli("monkaS", "China", 12.3f, 5.6f);
        cb.gift.add(b1);

        ChocAmor c1 = new ChocAmor("gjsakgjas", "Romania", 3.0f);
        cb.gift.add(c1);

        Lindt l2 = new Lindt("gjsdgk", "Romania", 3.2f, 2.5f, 1.0f);

        cb.gift.forEach((element) -> {
            System.out.println(element.equals(l2));
        });

        Area area = new Area(cb, 5, "Politehnica");
        area.getBirthdayCard();
    }
}
