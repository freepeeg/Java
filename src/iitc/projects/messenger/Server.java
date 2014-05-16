package iitc.projects.messenger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        Server s = new Server(63400);
        s.start();
    }

    public void start() {
        BufferedReader in = null;
        try {
            ServerSocket server = new ServerSocket(port);
            Socket socket = server.accept();
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (in != null) {
            String line;
            try {
                while ((line = in.readLine()) != null)
                    System.out.println(line);
            } catch (IOException e) {
                System.out.println("Client has disconnected.");
            }
        }
    }
}

