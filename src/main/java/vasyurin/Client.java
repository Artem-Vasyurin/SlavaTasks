package vasyurin;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("127.0.0.1", 8000);

        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        writer.write("Get me some information\n");
        writer.flush();

        System.out.println(reader.readLine());


        writer.close();
        reader.close();
        clientSocket.close();
    }


}
