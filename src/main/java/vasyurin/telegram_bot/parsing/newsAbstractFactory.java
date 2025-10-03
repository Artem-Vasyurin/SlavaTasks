package vasyurin.telegram_bot.parsing;

import org.springframework.stereotype.Service;

import java.net.http.HttpClient;

@Service
public class newsAbstractFactory {
    HttpClient getHttpClient(NewsSource type) {
        return HttpClient.newHttpClient();
    }
}
