package vasyurin.telegram_bot.Meduza;

import lombok.SneakyThrows;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import vasyurin.telegram_bot.dto.AllXml;
import vasyurin.telegram_bot.dto.OneItemXML;
import vasyurin.telegram_bot.interfaces.NewsDataHandler;
import vasyurin.telegram_bot.dto.NewsRowData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.net.URI;
import java.time.LocalDate;


@Component
public class MeduzaDataHandler implements NewsDataHandler {


    private static final URI uri = URI.create("https://hxhrkwtayhhvzavy.30dvtsgew7hf.xyz/rss/all");

    public OneItemXML toObject(String xml){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AllXml.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            AllXml rss = (AllXml) jaxbUnmarshaller.unmarshal(new StringReader(xml));

            for (OneItemXML item : rss.getChannel().getNewsItems()){


                if (item.getDescription() != null) {
                    String clearDescription = cleanHtml(item.getDescription());
                    item.setDescription(clearDescription);
                }

                // Очищаем content
                if (item.getContent() != null) {
                    String clearContent = cleanHtml(item.getContent());
                    item.setContent(clearContent);
                }

            }

            return rss.getChannel().getNewsItems().get(0);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    private String cleanHtml(String html) {
        return html.replaceAll("(?s)<h4>.*?</h4>", "")
                .replaceAll("(?s)<b>.*?</b>", "")
                .replaceAll("(?s)<a[^>]*>.*?</a>", "")
                .replaceAll("<[^>]+>", "")
                .replaceAll("\\s+", " ")
                .trim();
    }

    @SneakyThrows
    @Override
    public OneItemXML handle(Document rowData) {
        OneItemXML news = new OneItemXML();

        Element item = rowData.select("item").first();
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

        news.setDate(String.valueOf(LocalDate.now().atStartOfDay()));
        System.out.println(java.time.LocalDate.now());

        System.out.println(news);


        return news;

    }
}
