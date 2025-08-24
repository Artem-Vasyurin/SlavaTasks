package vasyurin.repositories;

import org.springframework.stereotype.Component;
import vasyurin.dto.TimeDto;

@Component
public class InMemoryStorage implements TimeStorage{
    private final TimeRepository repository;

    public InMemoryStorage(TimeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(TimeDto timeDto) {
        repository.put(timeDto.currentDateTime(), timeDto);
    }
}
