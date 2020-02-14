package com.Strategies;

import com.storage.DataRepository;
import com.storage.SensorData;

import java.util.ArrayList;

public class BasicStepCountStrategy implements StepCountStrategy {
    private DataRepository repo;

    public BasicStepCountStrategy(DataRepository repo) {
        this.repo = repo;
    }

    @Override
    public int getTotalSteps() {
        ArrayList<SensorData> data = repo.getData();
        int steps = 0;

        for(SensorData d : data) {
            steps += d.getStepsCount();
        }

        return steps;
    }

    @Override
    public String getStrategyDescription() {
        return "Adds all sensor data values.";
    }
}
