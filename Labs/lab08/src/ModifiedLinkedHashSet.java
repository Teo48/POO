import java.util.Collection;
import java.util.LinkedHashSet;

public class ModifiedLinkedHashSet<T> extends LinkedHashSet<Integer> {
    @Override
    public boolean add(Integer integer) {
        if ((integer & 1) == 1) {
            return false;
        }

        return super.add(integer);
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return super.addAll(c);
    }
}
