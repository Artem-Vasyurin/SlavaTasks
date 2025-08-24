package vasyurin.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import vasyurin.apiclient.ApiClient;
import vasyurin.dto.TimeDto;
import vasyurin.persistence.JDBC;
import vasyurin.repositories.TimeRepository;
import vasyurin.repositories.TimeStorage;

import java.io.IOException;
import java.util.List;


@Service
public class TimeRepositoryUpdaterImpl implements TimeRepositoryUpdater {
    private final TimeRepository timeRepository;
    private final ApiClient apiClient;
    private final JDBC jdbc;
    private final List<TimeStorage> storages;

    public TimeRepositoryUpdaterImpl(TimeRepository timeRepository, ApiClient apiClient, JDBC jdbc, List<TimeStorage> storages) {
        this.timeRepository = timeRepository;
        this.apiClient = apiClient;
        this.jdbc = jdbc;
        this.storages = storages;
    }


    @Scheduled(fixedRate = 5000)
    public synchronized void updateProcess() throws IOException {
        TimeDto timeDto = apiClient.getTimeDto();

        for (TimeStorage storage : storages) {
            storage.save(timeDto);
        }

//        timeRepository.put(timeDto.currentDateTime(), timeDto);
//        jdbc.save(timeDto);
    }
}
