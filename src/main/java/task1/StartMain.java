package task1;

public class StartMain {
    public static void main(String[] args) throws InterruptedException {

        Printer p = new Printer();

        MyThread threadA = new MyThread(1, p, "A");
        MyThread threadB = new MyThread(2, p, "B");
        MyThread threadC = new MyThread(3, p, "C");

        threadA.start();
        threadB.start();
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();

    }
}
