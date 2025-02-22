package Assignment1;

public class Knickknack implements Runnable{
    private Workspace Workspace;
    public String[] instructions;
    public int numItems;
    public int completed = 0;
    public int remindEvery;
    public String name;

    public Knickknack(Workspace workspace, String[] instructions, String name, int numItems, int remindEvery) {
        this.Workspace = workspace;
        this.instructions = instructions;
        this.name = name;
        this.numItems = numItems;
        this.remindEvery = remindEvery;
    }

    public void run() {
        for (int i = 1; i < numItems + 1; i++) {
            int stepNum = 1;// wanted to keep track of where I was in the recipe, I am aware this is unnecessary
            for (String step : instructions) {
                Station station = Workspace.getStation(step);
                if(station != null){// if the step requires a station in the work space get the lock on it
                    int waitCount = 0;
                    while(!station.stationLock.tryLock()){// repeatedly tries to get the lock, this way I can see what knickknack is waiting for a particular station when debugging
                        //this loop is unnecessary as well, I could have done this with station.stationLock.lock() and I would get the same behaviour, I just wanted to see what knickknacks are waiting for stations
//                        if (waitCount == 0) {
//                            System.out.println("Item: "+name+" is waiting for "+station.stationName+" to make item: "+completed);
//                            waitCount++;
//                        }
                    }
//                    System.out.println("Item: "+name+". Step " + stepNum + " of item num: " + i + ". Doing step " + station.stationName + ".");
                    stepNum++;
                    station.stationLock.unlock();
                }else{// step doesn't require any station, this was really for debugging, again I am aware this is unnecessary
//                    System.out.println("Item: "+name+" is doing an intermediate step("+stepNum+") for item num: "+i);
                }
            }
            if(completed % remindEvery == 0 && completed > 0){
                System.out.println(name+" has completed "+completed+"!");
            }

            completed++;
        }
        System.out.println(name+" has completed all "+completed+"!");
    }

}
