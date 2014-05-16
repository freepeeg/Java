package iitc.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * FileWriter
 *
 * @author Ian
 * @version 1.0
 */
public class FileWriter {

    public static void write(InputStream stream, BufferedOutputStream out) throws IOException {
        write(new BufferedInputStream(stream, 1024), out);
    }

    public static void write(BufferedInputStream in, BufferedOutputStream out) throws IOException {
        byte[] data = new byte[1024];
        int i;
        while ((i = in.read(data, 0, 1024)) >= 0)
            out.write(data, 0, i);
        in.close();
        out.close();
    }

}
