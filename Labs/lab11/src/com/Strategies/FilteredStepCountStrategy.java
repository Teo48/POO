package com.Strategies;

import com.storage.DataRepository;
import com.storage.SensorData;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FilteredStepCountStrategy implements StepCountStrategy {
    private static final int MAX_DIFF_STEPS_CONSECUTIVE_RECORDS = 1000;
    private static final long TIME_FOR_MAX_DIFF = TimeUnit.SECONDS.toMillis(1);

    private DataRepository repo;

    public FilteredStepCountStrategy(DataRepository repo) {
        this.repo = repo;
    }

    @Override
    public int getTotalSteps() {
        ArrayList<SensorData> data = repo.getData();
        int steps = 0;

        if(data.get(0).getStepsCount() > 0 && data.get(0).getStepsCount() < 1000) {
            steps+= data.get(0).getStepsCount();
        }

        for(int i = 1 ; i < data.size(); ++i) {
            SensorData last = data.get(i - 1);
            SensorData d = data.get(i);
            if(d.getStepsCount() > 0 && d.getStepsCount() < MAX_DIFF_STEPS_CONSECUTIVE_RECORDS
                    && d.getTimestamp() - last.getTimestamp() > TIME_FOR_MAX_DIFF) {
                steps += d.getStepsCount();
            }
        }

        return steps;
    }

    @Override
    public String getStrategyDescription() {
        return "Returns sum of all data values in range [0,1000], received longer than 1 second ago.";
    }
}
