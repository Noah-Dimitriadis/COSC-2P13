package Assignment1;

import java.util.concurrent.locks.ReentrantLock;
// a station is basically a thing that holds a lock because we dont have to worry about
// actually making anything, I just wanted to visualize things better
public class Station {
    String stationName;
    ReentrantLock stationLock;

    public Station(String name){
        this.stationName = name;
        stationLock = new ReentrantLock();
    }
}
