package main.java.vasyurin;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Timer;
import java.util.TimerTask;

public class TimeClient {
    public static void main(String[] args) throws IOException {
        startTimer();

    }

    private static void TakeTimeJson() {
        String url = "http://worldclockapi.com/api/json/est/now";

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String json = response.body();




        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Ошибка " + e.getMessage());
        }
    }

    private static void startTimer() {
        System.out.println("TimerTask run");
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                TakeTimeJson();
            }
        };

        timer.scheduleAtFixedRate(task, 0, 3600000);
    }
}
