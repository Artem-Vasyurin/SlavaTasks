package vasyurin;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class TimeController {
    private final TimeRepository timeRepository;
    private final Scanner scanner = new Scanner(System.in);

    public TimeController(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    //@Scheduled(fixedRate = 5000)
    public void start() {
        while (true) ask();
    }

    private void ask() {

        String input = scanner.nextLine();
        long unixTime = Long.parseLong(input);
        TimeDto timeDto = timeRepository.getClosest(unixTime);
        System.out.println(timeDto == null ? "repository is empty" : timeDto);

    }
}
