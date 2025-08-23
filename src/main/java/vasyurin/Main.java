package vasyurin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vasyurin.apiclient.ApiClient;
import vasyurin.apiclient.ApiClientImpl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.OffsetTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    private static ApiClient apiClient;

    public static void main(String[] args) throws SQLException {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(CommonConfiguration.class);
        appContext.getBean(TimeController.class).start();

        JDBC jdbc = new JDBC();
        jdbc.ReadTimeDto();

    }

}