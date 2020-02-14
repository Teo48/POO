package com.observers;

import com.communication.ServerMessage;
import com.main.Utils;
import com.storage.SensorData;

import java.util.Observable;
import java.util.Observer;

public class ServerCommunicationController implements Observer {

    @Override
    public void update(Observable observable, Object o) {
        if(o.getClass() == SensorData.class) {
            SensorData data = (SensorData) o;
            ServerMessage msg = new ServerMessage(data.getStepsCount(), Utils.getClientId(), data.getTimestamp());
            System.out.println(msg);
        }
    }

}
