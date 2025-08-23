package vasyurin;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import vasyurin.apiclient.ApiClientImpl;

@Configuration
@ComponentScan
@EnableScheduling
public class CommonConfiguration {

}
