package vasyurin.telegram_bot.Meduza;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import vasyurin.telegram_bot.interfaces.NewsDataHandler;
import vasyurin.telegram_bot.interfaces.NewsRowData;
import vasyurin.telegram_bot.dto.NewsData;




@Component
public class MeduzaDataHandler implements NewsDataHandler {
    MeduzaHttpClient meduzaHttpClient = new MeduzaHttpClient();
    Document doc;

    @Override
    public NewsData handle(Document rowData) {
        doc = meduzaHttpClient.request();
        NewsData news = new NewsData();

        Element item = doc.select("item").first();
        if (item == null) {
            throw new RuntimeException("RSS пустой");
        }

        String title = item.select("title").first().text();
        news.setTitle(title);
        System.out.println(title);

        String description = item.select("description").first().text();
        news.setDescription(description);
        System.out.println(description);

        String content = item.getElementsByTag("content:encoded").first().text();
        news.setContent(content);
        System.out.println(content);

        news.setDate(java.time.LocalDate.now().toString());
        System.out.println(java.time.LocalDate.now());

        return news;

    }
}
