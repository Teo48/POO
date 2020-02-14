package third;

import second.Container;
import second.Queue;
import second.Stack;

public class ContainerFactory implements IFactory {
    public static final ContainerFactory INSTANCE = new ContainerFactory();

    private ContainerFactory() {
    }

    public Container createContainer(Strategy strategy) {

//        Container container = switch (strategy) {
//            case FIFO -> new Queue();
//            case LIFO -> new Stack();
//        };

        Container container = null;
        if (strategy == Strategy.FIFO) {
            container = new Queue();
        }

        if (strategy == Strategy.LIFO) {
            container = new Stack();
        }
        return container;
    }
}