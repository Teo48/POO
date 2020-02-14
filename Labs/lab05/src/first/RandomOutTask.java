package first;

import java.util.Random;

public class RandomOutTask implements Task {
    private int randomNumber;

    public RandomOutTask() {
        this.randomNumber = new Random().nextInt(Integer.MAX_VALUE);
    }

    @Override
    public void execute() {
        System.out.println(randomNumber);
    }
}
