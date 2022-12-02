package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            //Good practice to wrap the InputStreamReader in a BufferedReader
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //Good practice to wrap the outputStream in a PrintWriter
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            //Typical scanner asking for input
            Scanner scanner = new Scanner(System.in);
            String outgoing;
            String incoming;

            do {
                System.out.print("Enter Text: ");
                outgoing = scanner.nextLine();

                output.println(outgoing);
                if(!outgoing.equals("exit")) {
                    incoming = input.readLine();
                    System.out.println(incoming);
                }
            } while(!outgoing.equals("exit"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
