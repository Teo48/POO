package fourth;

import first.Task;
import second.Stack;
import third.Strategy;

public class RedoBackTaskRunner extends AbstractTaskRunner {
    private Stack stack;

    public RedoBackTaskRunner(Strategy strategy) {
        super(strategy);
        stack = new Stack();
    }

    @Override
    protected void afterExecution(Task task) {
        stack.push(task);
    }

    public void redo() {
        while (!stack.isEmpty()) {
            stack.pop().execute();
        }
    }
}
