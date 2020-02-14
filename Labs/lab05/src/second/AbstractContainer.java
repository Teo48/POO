package second;

import first.Task;

import java.util.ArrayList;

public abstract class AbstractContainer implements Container {
    ArrayList<Task> list;

    public AbstractContainer() {
        list = new ArrayList<>();
    }

    @Override
    public Task pop() {
        try {
            return list.remove(0);
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void transferFrom(Container container) {
        while (!container.isEmpty()) {
            push(container.pop());
        }
    }
}
