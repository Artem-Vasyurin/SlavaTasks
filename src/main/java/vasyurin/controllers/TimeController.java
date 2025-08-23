package vasyurin.controllers;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import vasyurin.dto.TimeDto;
import vasyurin.repositories.TimeRepository;

import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

@Service
public class TimeController {
    private final TimeRepository timeRepository;
    private final Scanner scanner = new Scanner(System.in);

    private Thread thread;

    public TimeController(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @PostConstruct
    public void postConstruct() {
        thread = new Thread(() -> Stream.generate(() -> 1).forEach(i -> ask()));
        thread.start();
    }

    private void ask() {
        String input = scanner.nextLine();
        long unixTime = Long.parseLong(input);

        timeRepository.getClosest(unixTime)
                .map(TimeDto::toString)
                .or(() -> Optional.of("repository is empty"))
                .ifPresent(System.out::println);
    }
}
