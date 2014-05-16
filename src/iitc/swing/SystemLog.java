package iitc.swing;

import java.io.*;

/**
 * SystemLog
 *
 * @author Ian
 * @version 1.0
 */
public class SystemLog extends Log implements Runnable {
    private BufferedReader reader;

    public SystemLog(String... beginningStatements) throws IOException {
        super(beginningStatements);
        PipedOutputStream pOut = new PipedOutputStream();
        PipedInputStream pIn = new PipedInputStream(pOut);
        reader = new BufferedReader(new InputStreamReader(pIn));
        PrintStream stream = new PrintStream(pOut);
        System.setErr(stream);
        System.setOut(stream);
    }

    @Override
    public void run() {
        try {
            for (String log = reader.readLine(); log != null; log = reader.readLine())
                log(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
