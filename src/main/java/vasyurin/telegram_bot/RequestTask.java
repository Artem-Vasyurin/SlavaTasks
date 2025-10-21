package vasyurin.telegram_bot;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import vasyurin.telegram_bot.dto.AllXml;
import vasyurin.telegram_bot.dto.NewsRowData;
import vasyurin.telegram_bot.dto.OneItemXML;
import vasyurin.telegram_bot.interfaces.NewsStorage;
import vasyurin.telegram_bot.interfaces.NewsAbstractFactory;


@Service
public class RequestTask {
    private final NewsAbstractFactory newsFactory;
    private final NewsStorage storage;

    public RequestTask(NewsAbstractFactory newsFactory, NewsStorage storage) {
        this.newsFactory = newsFactory;
        this.storage = storage;
    }

    @Scheduled(fixedDelayString = "PT5S")
    public void requestMeduzaNews()  {

        final NewsSource sourceType = NewsSource.MEDUZA;
        System.out.println("requestMeduzaNews: " + sourceType);

        String rowNews2 = newsFactory.getClient(sourceType).getRowDate();
        OneItemXML news2 = newsFactory.getDataHandler(sourceType).toObject(rowNews2);

//        Document rowNews = newsFactory.getClient(sourceType).request();
//        NewsData news = newsFactory.getDataHandler(sourceType).handle(rowNews);

        storage.save(news2);
        System.out.println(news2.toString());

    }
}
