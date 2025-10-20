package vasyurin.TimeServideProject.repositories;

import vasyurin.TimeServideProject.dto.TimeDto;
import java.io.IOException;

public interface TimeStorage {
    void save(TimeDto timeDto) throws IOException;
}
