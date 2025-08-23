package vasyurin.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import vasyurin.apiclient.ApiClient;
import vasyurin.dto.TimeDto;
import vasyurin.repositories.TimeRepository;


@Service
public class TimeRepositoryUpdater {
    private final TimeRepository timeRepository;
    private final ApiClient apiClient;

    public TimeRepositoryUpdater(TimeRepository timeRepository, ApiClient apiClient) {
        this.timeRepository = timeRepository;
        this.apiClient = apiClient;
    }

    @Scheduled(fixedRate = 5000)
    public synchronized void updateProcess() {
        TimeDto timeDto = apiClient.getTimeDto();
        timeRepository.put(timeDto.currentDateTime(), timeDto);
    }
}
