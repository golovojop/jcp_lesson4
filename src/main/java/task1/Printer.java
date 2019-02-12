package task1;

import static task1.StartMain.THREADS;

public class Printer {
    private static int nextId = 1;

    public synchronized void print(int id, String message) {

        try {
            while(id != nextId) {
                wait();
            }
            System.out.println(message);
            if(nextId == THREADS) nextId = 1;
            else nextId++;
            notifyAll();

        } catch (InterruptedException e) {e.printStackTrace();}
    }
}
