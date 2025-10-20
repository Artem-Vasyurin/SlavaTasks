package vasyurin.telegram_bot;

import org.springframework.stereotype.Service;
import vasyurin.telegram_bot.dto.NewsData;
import vasyurin.telegram_bot.interfaces.NewsStorage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class InFileSave implements NewsStorage {
    @Override
    public void save(NewsData news) {
        try (FileWriter fileWriter = new FileWriter("srsMeduza.txt")) {

            fileWriter.write("\n");
            fileWriter.write(news.getTitle());
            fileWriter.write("\n");
            fileWriter.write(news.getDescription());
            fileWriter.write("\n");
            fileWriter.write(news.getContent());
            fileWriter.write("\n");
            fileWriter.write(news.getDate());
            fileWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
