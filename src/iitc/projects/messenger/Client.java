package iitc.projects.messenger;

import iitc.util.Time;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread {
    private final Socket socket;
    private PrintWriter printWriter;
    private State state;

    private Client() {
        throw new IllegalArgumentException("Here just to avoid compile issues.");
    }

    public Client(int port) {
        try {
            socket = new Socket("localhost", port);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to connect to server.");
        }
        try {
            printWriter = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            throw new IllegalStateException("Server is not connected.");
        }
        this.state = State.OPEN;
    }

    public static void main(String[] args) {
        try {
            Client t = new Client(63400);
            t.start();
            t.println("Test string.");
            Time.sleep(2500);
            t.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void run() {
        while (state != State.CLOSED)
            Time.sleep(15);
        end();
    }

    public void disconnect() {
        state = State.CLOSED;
    }

    private void end() {
        printWriter.close();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(Object object) {
        printWriter.println(object);
    }

    enum State {IDLE, OPEN, CLOSED}
}

