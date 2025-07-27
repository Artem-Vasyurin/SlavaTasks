package main.java.vasyurin;

import java.io.*;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("worldclockapi.com", 80);

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());

        writer.write("GET /api/json/utc/now HTTP/1.1\r\n");
        writer.write("Host: worldclockapi.com\r\n");
        writer.write("Connection: close\r\n");
        writer.write("\r\n");
        writer.flush();
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        socket.close();

    }
}
