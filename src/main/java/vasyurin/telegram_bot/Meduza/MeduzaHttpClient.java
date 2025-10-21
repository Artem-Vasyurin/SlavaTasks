package vasyurin.telegram_bot.Meduza;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import java.net.http.HttpClient;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Component
public class MeduzaHttpClient implements vasyurin.telegram_bot.interfaces.HttpClient {
    private final String url = "https://hxhrkwtayhhvzavy.30dvtsgew7hf.xyz/rss/all";


    public Document request() {
        try {
            return Jsoup.connect(url.toString()).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getRowDate(){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }


//    @Override
//    public NewsRowData request() {
//        try {
//            System.out.println("начинаю подключаться");
//            Document doc = Jsoup.connect(uri.toString()).get();
//            System.out.println("подключился");
//
//            Element item = doc.select("item").first();
//            if (item == null) {
//                throw new RuntimeException("RSS пустой");
//            }
//
//            String title = item.select("title").first().text();
//            String description = item.select("description").first().text();
//            String content = item.getElementsByTag("content:encoded").first().text();
//            return new MeduzaRowData(title, description, content);
//        } catch (IOException e) {
//            throw new RuntimeException("ошибка при запросе у медузы", e);
//        }
//    }

}