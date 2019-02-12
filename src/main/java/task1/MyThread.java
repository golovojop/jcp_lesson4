package task1;

public class MyThread extends  Thread {

    private Printer printer;
    private char ch;
    private int id;

    public MyThread(int id , Printer printer, char ch) {
        this.printer = printer;
        this.ch = ch;
        this.id = id;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            printer.print(id, Character.toString(ch));
        }
    }
}


