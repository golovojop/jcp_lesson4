package task1;

import java.util.ArrayList;

public class StartMain {

    public static final int THREADS = 3;

    public static void main(String[] args) throws InterruptedException {
        Printer p = new Printer();
        char ch = 'A';

        ArrayList<Thread> al = new ArrayList<>();

        for(int i = 0; i < THREADS; i++) {
            al.add(new MyThread((i + 1), p, ch++));
        }

        al.forEach(t -> t.start());
        al.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {e.printStackTrace();}
        });

//        MyThread threadA = new MyThread(1, p, ch++);
//        MyThread threadB = new MyThread(2, p, ch++);
//        MyThread threadC = new MyThread(3, p, ch++);
//
//        threadA.start();
//        threadB.start();
//        threadC.start();
//
//        threadA.join();
//        threadB.join();
//        threadC.join();

    }
}
