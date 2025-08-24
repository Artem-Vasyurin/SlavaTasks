package vasyurin.repositories;

import vasyurin.dto.TimeDto;
import java.io.IOException;

public interface TimeStorage {
    void save(TimeDto timeDto) throws IOException;
}
