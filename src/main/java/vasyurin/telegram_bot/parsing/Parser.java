package vasyurin.telegram_bot.parsing;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.*;
import java.net.*;



@Service
public class Parser {

    @Scheduled(fixedRate = 5000)
    static void getConnection() throws IOException, SAXException {
        URI uri = URI.create("https://hxhrkwtayhhvzavy.30dvtsgew7hf.xyz/rss/all");
        XMLReader reader = XMLReaderFactory.createXMLReader();
        RSSHandler handler = new RSSHandler();
        reader.setContentHandler(handler);
        reader.parse(uri.toString());
        System.out.println("типо парсинг");

    }
}
