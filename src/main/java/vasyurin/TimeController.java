package vasyurin;

import java.util.Scanner;

public class TimeController {
    private final TimeRepository timeRepository;

    public TimeController(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    public void start() {
        while (true) ask();
    }

    private void ask() {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            long unixTime = Long.parseLong(input);
            TimeDto timeDto = timeRepository.getClosest(unixTime);
            System.out.println(timeDto == null ? "repository is empty" : timeDto);
        }
    }
}
