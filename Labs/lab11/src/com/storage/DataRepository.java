package com.storage;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Persists sensor data. Observable, its observers are notified when data is added it to.
 */
public class DataRepository extends Observable { // TODO make this an Observable

    private ArrayList<SensorData> data = new ArrayList<SensorData> ();


    public void addData(SensorData dataRecord){
        data.add(dataRecord);
        setChanged();
        notifyObservers(dataRecord);
    }

    // TODO implement a method to get the stored data (needed by the strategies)

    public ArrayList<SensorData> getData() {
        return data;
    }
}


