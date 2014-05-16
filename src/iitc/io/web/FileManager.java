package iitc.io.web;

import java.io.*;
import java.net.URL;

/**
 * FileManager
 *
 * @author Ian
 * @version 1.0
 */
public class FileManager {

    public static void download(String path, String fileName) throws IOException {
        download(new URL(path), fileName);
    }

    public static void download(URL url, String fileName) throws IOException {
        writeAs(fileName, url.openStream());
    }

    private static void writeAs(String fileName, InputStream stream) throws IOException {
        writeAs(fileName, new BufferedInputStream(stream));
    }

    private static void writeAs(String fileName, BufferedInputStream in) throws IOException {
        iitc.io.FileWriter.write(in, new BufferedOutputStream(new FileOutputStream(fileName)));
    }

}
