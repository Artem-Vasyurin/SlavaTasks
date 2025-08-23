package vasyurin.repositories;

import org.springframework.stereotype.Service;
import vasyurin.dto.TimeDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

@Service
public class TimeRepository {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmXXX");

    private HashMap<String, TimeDto> hashMap = new HashMap<>();

    public synchronized void put(String timeString, TimeDto timeDto) {
        hashMap.put(timeString, timeDto);
    }

    public synchronized Optional<TimeDto> getClosest(Long utcMills) {
        TimeDto result;
        if (hashMap.isEmpty()) {
            result = null;
        } else if (hashMap.size() == 1) {
            result = hashMap.values().iterator().next();
        } else {
            result = findClosest(utcMills);
        }
        return Optional.ofNullable(result);
    }

    private TimeDto findClosest(Long utcMills) {
        try {
            Date userDate = new Date(utcMills);
            Date closestKey = null;
            for (String key : hashMap.keySet()) {
                Date keyDate = dateFormat.parse(key);
                if (closestKey == null) {
                    closestKey = keyDate;
                } else {
                    if (closestKey.compareTo(userDate) > keyDate.compareTo(userDate)) {
                        closestKey = keyDate;
                    }
                }
            }
            return hashMap.get(dateFormat.format(closestKey));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
