package Assignment1;

import java.util.Objects;
import java.util.Scanner;

public class Workspace {
    public Station[] stations;

    public Workspace(){
        stations = new Station[7];
        // order doesnt matter, just need to initialize all the stations
        stations[0] = new Station("FDM Printer");
        stations[1] = new Station("Resin Printer");
        stations[2] = new Station("Soldering Iron");
        stations[3] = new Station("Toaster Oven");
        stations[4] = new Station("Lathe");
        stations[5] = new Station("Mill");
        stations[6] = new Station("Airbrush");
    }

    // check if a station with the name 'target' exists in our list of stations and return it if it does
    public Station getStation(String target){
        for (Station station: stations) {
            if(Objects.equals(target, station.stationName)){
                return station;
            }
        }
        return null;
    }

    // prints the menu to the console for selection and returns all the threads with all the knickknack objects
    public Thread[] presentMenu(){
        Scanner scan = new Scanner(System.in);
        Thread[] items = new Thread[7];
        boolean finishedFlag = false;

        System.out.println("Welcome to the makerspace! What would you like to make?\nPress the number of the item you wish to make to get started.\n" +
                "If you wish to change the number of items for a particular knickknack press the number again to redo the selection, the previous one will be overwritten.");

        for (int i = 0; i < 7; i++) {
            if(finishedFlag){
                break;
            }

            int remindEvery = 0;
            int numItems = 0;
            System.out.print("1. Figurines for Mazes and Monsters\n" +
                    "2. Motor Controllers with Custom PCBs\n" +
                    "3. Chess Set\n" +
                    "4. Toaster Pastry\n" +
                    "5. Cup Holder\n" +
                    "6. SAK Scales\n" +
                    "7. Flashlight\n" +
                    "8. Make 1 million of each knickknack and notify every 100,000\n" +
                    "0. No more Knickknacks\n" +
                    "Enter your choice:");
            int item = scan.nextInt();

            //actual menu printing here
            switch (item){

                case 1:
                    System.out.print("You have chosen to make Figurines for Mazes and Monsters!\nHow many would you like to make: ");
                    numItems = scan.nextInt();
                    System.out.print("How often would you like to be reminded(e.g. If i wanted to be reminded every millionth knickknack I would enter 1000000)\nRemind every:");
                    remindEvery = scan.nextInt();
                    Thread Figurine = new Thread(new Knickknack(this, new String[] {"Resin Printer", "Airbrush", null}, "DND Figurine", numItems, remindEvery));
                    items[0] = Figurine;
                    break;

                case 2:
                    System.out.print("You have chosen to make Motor Controllers with Custom PCBs!\nHow many would you like to make: ");
                    numItems = scan.nextInt();
                    System.out.print("How often would you like to be reminded(e.g. If i wanted to be reminded every millionth knickknack I would enter 1000000)\nRemind every:");
                    remindEvery = scan.nextInt();
                    Thread Controller = new Thread(new Knickknack(this, new String[] {"Soldering Iron", "Mill", null, null, "Toaster Oven", "Mill", "Soldering Iron", null}, "Motor Controllers", numItems, remindEvery));
                    items[1] = Controller;
                    break;

                case 3:
                    System.out.print("You have chosen to make Chess Set!\nHow many would you like to make: ");
                    numItems = scan.nextInt();
                    System.out.print("How often would you like to be reminded(e.g. If i wanted to be reminded every millionth knickknack I would enter 1000000)\nRemind every:");
                    remindEvery = scan.nextInt();
                    Thread ChessSet = new Thread(new Knickknack(this, new String[] {"Resin Printer", "Lathe", "Resin Printer", "Lathe", "FDM Printer", null}, "Chess Set", numItems, remindEvery));
                    items[2] = ChessSet;
                    break;

                case 4:
                    System.out.print("You have chosen to make Toaster Pastry!\nHow many would you like to make: ");
                    numItems = scan.nextInt();
                    System.out.print("How often would you like to be reminded(e.g. If i wanted to be reminded every millionth knickknack I would enter 1000000)\nRemind every:");
                    remindEvery = scan.nextInt();
                    Thread ToasterPastry = new Thread(new Knickknack(this, new String[] {"Toaster Oven", null, null, null, null}, "Toaster Pastry", numItems, remindEvery));
                    items[3] = ToasterPastry;
                    break;

                case 5:
                    System.out.print("You have chosen to make Cup Holder!\nHow many would you like to make: ");
                    numItems = scan.nextInt();
                    System.out.print("How often would you like to be reminded(e.g. If i wanted to be reminded every millionth knickknack I would enter 1000000)\nRemind every:");
                    remindEvery = scan.nextInt();
                    Thread CupHolder = new Thread(new Knickknack(this, new String[] {"Toaster Oven", "FDM Printer", "Airbrush", null}, "Cup Holder", numItems, remindEvery));
                    items[4] = CupHolder;
                    break;

                case 6:
                    System.out.print("You have chosen to make SAK Scales!\nHow many would you like to make: ");
                    numItems = scan.nextInt();
                    System.out.print("How often would you like to be reminded(e.g. If i wanted to be reminded every millionth knickknack I would enter 1000000)\nRemind every:");
                    remindEvery = scan.nextInt();
                    Thread SAKScales = new Thread(new Knickknack(this, new String[] {null, "Mill", null, null, "Toaster Oven", null}, "SAK Scales", numItems, remindEvery));
                    items[5] = SAKScales;
                    break;

                case 7:
                    System.out.print("You have chosen to make Flashlight!\nHow many would you like to make: ");
                    numItems = scan.nextInt();
                    System.out.print("How often would you like to be reminded(e.g. If i wanted to be reminded every millionth knickknack I would enter 1000000)\nRemind every:");
                    remindEvery = scan.nextInt();
                    Thread Flashlight = new Thread(new Knickknack(this, new String[] {"Lathe", null, "Soldering Iron"}, "Flashlight", numItems, remindEvery));
                    items[6] = Flashlight;
                    break;

                case 8:
                    Figurine = new Thread(new Knickknack(this, new String[] {"Resin Printer", "Airbrush", null}, "DND Figurine", 1000000, 100000));
                    Controller = new Thread(new Knickknack(this, new String[] {"Soldering Iron", "Mill", null, null, "Toaster Oven", "Mill", "Soldering Iron", null}, "Motor Controllers", 1000000, 100000));
                    ChessSet = new Thread(new Knickknack(this, new String[] {"Resin Printer", "Lathe", "Resin Printer", "Lathe", "FDM Printer", null}, "Chess Set", 1000000, 100000));
                    ToasterPastry = new Thread(new Knickknack(this, new String[] {"Toaster Oven", null, null, null, null}, "Toaster Pastry", 1000000, 100000));
                    CupHolder = new Thread(new Knickknack(this, new String[] {"Toaster Oven", "FDM Printer", "Airbrush", null}, "Cup Holder", 1000000, 100000));
                    SAKScales = new Thread(new Knickknack(this, new String[] {null, "Mill", null, null, "Toaster Oven", null}, "SAK Scales", 1000000, 100000));
                    Flashlight = new Thread(new Knickknack(this, new String[] {"Lathe", null, "Soldering Iron"}, "Flashlight", 1000000, 100000));
                    items[0] = Figurine;
                    items[1] = Controller;
                    items[2] = ChessSet;
                    items[3] = ToasterPastry;
                    items[4] = CupHolder;
                    items[5] = SAKScales;
                    items[6] = Flashlight;
                    finishedFlag = true;
                    break;

                case 0:
                    System.out.println("Thank you for your selections!");
                    finishedFlag = true;
                    break;

                default:
                    System.out.println("Invalid input, please choose a number corresponding to the Knickknack you wish to make.");
                    break;
            }
        }

        return items;
    }

    public static void main(String[] args){
        Workspace w = new Workspace();
        Thread[] items = w.presentMenu();

        //start each thread gathered from the menu
        for (Thread item: items) {
            if(item != null){
                item.start();
            }
        }

        //join each thread and finish
        for (Thread item: items) {
            if(item != null){
                try{
                    item.join();
                }catch (InterruptedException ie){

                }
            }
        }
        System.out.println("All finished!");
    }
}
