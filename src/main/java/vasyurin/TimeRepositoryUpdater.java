package vasyurin;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import vasyurin.apiclient.ApiClient;

import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;


@Service
public class TimeRepositoryUpdater {
    private final Timer timer = new Timer();

    private final TimeRepository timeRepository;
    private final ApiClient apiClient;

    private volatile boolean isStarted;

    public TimeRepositoryUpdater(TimeRepository timeRepository, ApiClient apiClient) {
        this.timeRepository = timeRepository;
        this.apiClient = apiClient;
    }

    @Scheduled(fixedRate = 5000)
    public synchronized void start() {
        if (isStarted) return;

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                TakeTimeJson();
            }
        };

        timer.scheduleAtFixedRate(task, 0, 5_000);
        isStarted = true;
    }

    private void TakeTimeJson() {


        TimeDto timeDto = apiClient.getTimeDto();
        timeRepository.put(timeDto.currentDateTime(), timeDto);


    }
}
