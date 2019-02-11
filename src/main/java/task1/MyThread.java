package task1;

public class MyThread extends  Thread {
    public static final int THREADS = 3;

    private String message;
    private Printer printer;
    private int id;

    public MyThread(int id , Printer printer, String message) {
        this.message = message;
        this.printer = printer;
        this.id = id;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            printer.print(id, message);
        }
    }
}


