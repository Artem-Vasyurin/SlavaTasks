package vasyurin.telegram_bot.interfaces;

import org.springframework.stereotype.Service;
import vasyurin.telegram_bot.NewsSource;

@Service
public interface NewsAbstractFactory {

    HttpClient getClient(NewsSource type);

    NewsDataHandler getDataHandler(NewsSource type);
}
