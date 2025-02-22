package Assignment1;

import java.util.concurrent.locks.ReentrantLock;

public class SimpleTask {
    private int todo;//could put a volatile here too if we wanted but its nr needed
    private volatile int confirmed;
    private ReentrantLock lock;

    public SimpleTask() {
        lock = new ReentrantLock();
        todo = 20000000; //How many times we want the Worker to do its thing
        System.out.println("Ready...");

        Thread t = new Thread(new Worker(1));
        Thread t2 = new Thread(new Worker(2));

        t.start(); //Note: we call 'start()', not 'run()'!
        t2.start();
        try {
            t.join();
            t2.join();
        } catch (InterruptedException ie) {

        }
        System.out.println("Done!\n" + confirmed);
    }

    private class Worker implements Runnable {
        private int id;
        public Worker(int id){this.id = id;}
        public void run() {
            System.out.println("\t "+id+" Thinking...");
            while (true) {
                lock.lock();
                try{
                    if (todo == 0) break;
                    todo--;
                    confirmed++;
                }finally {
                    lock.unlock();
                }
            }
            System.out.println("\t "+id+ " completed!");
        }
    }

    public static void main(String[] args) {
        new SimpleTask();
    }
}
