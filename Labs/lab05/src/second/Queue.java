package second;

import first.Task;

public class Queue extends AbstractContainer {
    @Override
    public void push(Task task) {
        list.add(task);
    }
}
