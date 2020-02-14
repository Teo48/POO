package com.observers;

import com.storage.SensorData;

import java.util.Observable;
import java.util.Observer;

public class ConsoleLogger implements Observer {

    @Override
    public void update(Observable observable, Object o) {
        if(o.getClass() == SensorData.class) {
            SensorData data  = (SensorData) o;
            System.out.println("New data: " + data);
        }

    }
}
