package vasyurin.telegram_bot.Meduza;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import vasyurin.telegram_bot.interfaces.HttpClient;

import java.io.IOException;
import java.net.URI;

@Component
public class MeduzaHttpClient implements HttpClient{
    private static final URI uri = URI.create("https://hxhrkwtayhhvzavy.30dvtsgew7hf.xyz/rss/all");

    public Document request() {
        try {
            return Jsoup.connect(uri.toString()).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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