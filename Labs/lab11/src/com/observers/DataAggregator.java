package com.observers;

import com.Strategies.StepCountStrategy;
import com.storage.SensorData;

import java.util.Observable;
import java.util.Observer;

public class DataAggregator implements Observer {
    StepCountStrategy strategy;

    public DataAggregator(StepCountStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void update(Observable observable, Object o) {
        if(o.getClass() == SensorData.class) {
            System.out.println("Total steps: " + strategy.getTotalSteps() + ". " + strategy.getStrategyDescription());
        }

    }
}
