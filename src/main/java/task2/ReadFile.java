package task2;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) {
        byte[] buffer = new byte[512];
        int n;

        System.out.println("\nTrying to read syslog file:\n");

        try (FileInputStream in = new FileInputStream("files/task2.txt")) {
            while ((n = in.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, n));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
