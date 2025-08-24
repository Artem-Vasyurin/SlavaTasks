package vasyurin.persistence;

import org.springframework.stereotype.Component;
import vasyurin.dto.TimeDto;
import vasyurin.repositories.TimeStorage;
import java.io.IOException;

@Component
public class DatabaseStorage implements TimeStorage {

    private final JDBC jdbc;

    public DatabaseStorage(JDBC jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void save(TimeDto timeDto) throws IOException {
        jdbc.save(timeDto);
    }
}
