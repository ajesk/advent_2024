package io.acode.util;

import java.io.FileOutputStream;

public class FileWriter {
    public static void write(String str, String file) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file, true);
            fos.write(str.getBytes());
            fos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
