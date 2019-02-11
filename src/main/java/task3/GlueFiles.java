package task3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class GlueFiles {

    private static final int FILES_QTY = 5;

    public static void main(String[] args) {
        ArrayList<InputStream> al = new ArrayList<>();
        byte[] buffer = new byte[512];

        // Добавить файлы в коллекцию
        for (int i = 1; i <= FILES_QTY; i++) {
            try {
                al.add(new FileInputStream(String.format("files/task3-%d.txt", i)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        // Поместить коллекцию файлов в SequenceInputStream,
        // Последовательно читать файлы и записывать их
        // содержимое в результирующий файл.
        try (SequenceInputStream in = new SequenceInputStream(Collections.enumeration(al));
             FileOutputStream os = new FileOutputStream("files/task3-result.txt")) {

            int m = 0;
            while ((m = in.read(buffer)) != -1) {
                os.write(buffer, 0, m);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            al.forEach((s) -> {
                try {
                    if (s != null) s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
