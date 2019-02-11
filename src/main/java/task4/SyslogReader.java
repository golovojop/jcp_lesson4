package task4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SyslogReader {

    // Размер страницы чтения
    private static final int PAGE = 1800;

    public static void main(String[] aargs) {

        // Буфер чтения
        byte[] buffer = new byte[PAGE];

        try (FileInputStream is = new FileInputStream("files/syslog.txt")){

            long t = System.currentTimeMillis();
            int n = 0;

            while((n = is.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, n));
            }
            System.out.println("\n===============\nElapsed time: " + (System.currentTimeMillis() - t) + "ms");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
