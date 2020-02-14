package com.main;

import com.Strategies.StepCountStrategy;
import com.Strategies.StepCountStrategyFactory;
import com.observers.ConsoleLogger;
import com.observers.DataAggregator;
import com.observers.ServerCommunicationController;
import com.storage.DataRepository;
import com.storage.SensorData;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Choose a strategy: type 'basic or 'filtered");
        Scanner scanner = new Scanner(System.in);
        String strategyType = scanner.next();
        scanner.close();

        DataRepository dataRepository = new DataRepository();
        // TODO: use the StepCountStrategyFactory to create a strategy

        StepCountStrategy myStrat = StepCountStrategyFactory.INSTANCE.createStrategy(strategyType, dataRepository);

        // TODO: add observers to the dataRepository
        // don't forget to provide the strategy to the DataAggregator observer

        dataRepository.addObserver(new ConsoleLogger());
        dataRepository.addObserver(new ServerCommunicationController());
        dataRepository.addObserver(new DataAggregator(myStrat));

        // TODO: uncomment
        long baseTimestamp = System.currentTimeMillis();

        dataRepository.addData(new SensorData(10, baseTimestamp + 1));
        System.out.println();

        dataRepository.addData(new SensorData(20, baseTimestamp + 2));
        System.out.println();

        dataRepository.addData(new SensorData(30, baseTimestamp + 3));
        System.out.println();

        // TODO: after the first successful run, change this to baseTimestamp + 40000 and check the result
        dataRepository.addData(new SensorData(55, baseTimestamp + 40000));
        System.out.println();

        dataRepository.addData(new SensorData(50, baseTimestamp + 5));
        System.out.println();

        dataRepository.addData(new SensorData(-100, baseTimestamp + 6));
        System.out.println();

        dataRepository.addData(new SensorData(500, baseTimestamp + 600));
        System.out.println();

    }
}
