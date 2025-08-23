package vasyurin.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public final class SpringApplication {
    private static ApplicationContext appContext;

    private SpringApplication() {}

    public static synchronized void run() {
        if (appContext == null) {
            appContext = new AnnotationConfigApplicationContext(CommonConfiguration.class);
        }
    }
}
