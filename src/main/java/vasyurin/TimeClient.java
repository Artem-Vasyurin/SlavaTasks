package vasyurin;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TimeClient {

    private static long unixTime;
    private static HashMap<String, TimeDto> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        startTimer();


        String input = scanner.nextLine();
        unixTime = Long.parseLong(input);

        LocalDateTime ldt = LocalDateTime.ofEpochSecond(unixTime, 0, ZoneOffset.ofHours(-4));
        TimeDto timeDto = new TimeDto();
        timeDto = hashMap.get(ldt+"-04:00");
        System.out.println(timeDto);

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


            TimeDto timeDto;
            timeDto = new ObjectMapper().readValue(json, TimeDto.class);
            convertDataTimeInUnixTime(timeDto);

            hashMap.put(timeDto.currentDateTime, timeDto);
            System.out.printf("TimeDto: %s\n", timeDto);



        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Ошибка " + e.getMessage());
        }
    }

    private static long convertDataTimeInUnixTime(TimeDto timeDto) {
        ZonedDateTime zdt = ZonedDateTime.parse(timeDto.currentDateTime, DateTimeFormatter.ISO_DATE_TIME);
        long unixTime = zdt.toEpochSecond();
        timeDto.unixDateTime = unixTime;
        return unixTime;
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

        timer.scheduleAtFixedRate(task, 0, 1600000);
    }

}
