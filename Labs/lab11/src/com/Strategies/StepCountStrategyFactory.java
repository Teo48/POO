package com.Strategies;

import com.main.Utils;
import com.storage.DataRepository;

public class StepCountStrategyFactory {
    public static StepCountStrategyFactory INSTANCE = new StepCountStrategyFactory();

    private StepCountStrategyFactory() {

    }

    public StepCountStrategy createStrategy(String strategyType, DataRepository dataRepository) {
        if(strategyType.equals(Utils.BASIC_STRATEGY)) {
            return new BasicStepCountStrategy(dataRepository);
        } else if (strategyType.equals(Utils.FILTERED_STRATEGY)) {
            return new FilteredStepCountStrategy(dataRepository);
        }

        return null;
    }
}
