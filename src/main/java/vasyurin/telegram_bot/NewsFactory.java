package vasyurin.telegram_bot;

import org.springframework.stereotype.Component;
import vasyurin.telegram_bot.Meduza.MeduzaDataHandler;
import vasyurin.telegram_bot.Meduza.MeduzaHttpClient;
import vasyurin.telegram_bot.interfaces.HttpClient;
import vasyurin.telegram_bot.interfaces.NewsDataHandler;
import vasyurin.telegram_bot.interfaces.NewsAbstractFactory;

@Component
public class NewsFactory implements NewsAbstractFactory {

    @Override
    public HttpClient getClient(NewsSource type) {
        return switch (type) {
            case MEDUZA -> new MeduzaHttpClient();
        };
    }

    @Override
    public NewsDataHandler getDataHandler(NewsSource type) {
        return switch (type) {
            case MEDUZA -> new MeduzaDataHandler();
        };
    }
}
