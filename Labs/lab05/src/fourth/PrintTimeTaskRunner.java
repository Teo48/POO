package fourth;

import first.Task;
import third.Strategy;

import java.util.Calendar;

public class PrintTimeTaskRunner extends  AbstractTaskRunner {
    private Calendar calendar;

    public PrintTimeTaskRunner(Strategy strategy) {
        super(strategy);
        calendar = Calendar.getInstance();
    }


    @Override
    protected void afterExecution(Task task) {
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
    }
}
