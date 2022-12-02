package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)) {
            while(true) {
                Socket socket = serverSocket.accept();
                Client client = new Client(socket);
                client.start();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
