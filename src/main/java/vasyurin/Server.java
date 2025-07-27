package main.java.vasyurin;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8000);

        int counter = 0;
        while (true) {
            Socket clientSocket = serverSocket.accept();

            System.out.println("New client connected:" + ++counter);

            OutputStreamWriter writer = new OutputStreamWriter(  clientSocket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String request = reader.readLine();
            String response = counter + ", Your message length is " + request.length() + "\n";

            writer.write("HTTP/1.0 200 OK\r\n " +
                    "Content-type: text/html\r\n" +
                    "\r\n" +
                    "<h1>" + response  + "</h1>\r\n " );
            writer.flush();

            reader.close();
            writer.close();
            clientSocket.close();
        }

    }
}
