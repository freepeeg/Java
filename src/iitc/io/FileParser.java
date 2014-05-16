package iitc.io;

import java.io.*;

/**
 * FileParser
 *
 * @author Ian
 * @version 1.0
 */
//TODO:Implement parsing methods
public class FileParser extends BufferedReader {
    public FileParser(InputStream in, int sz) {
        super(new InputStreamReader(in), sz);
    }

    public FileParser(InputStream in) {
        super(new InputStreamReader(in));
    }

    public FileParser(Reader in, int sz) {
        super(in, sz);
    }

    public FileParser(Reader in) {
        super(in);
    }

    public String dump() throws IOException {
        return dump(true);
    }

    public String dump(boolean skipLines) throws IOException {
        StringBuilder buffer = new StringBuilder();
        String string;
        while ((string = readLine()) != null) {
            buffer.append(string);
            if (skipLines)
                buffer.append("\n");
        }
        close();
        return buffer.toString();
    }
}
