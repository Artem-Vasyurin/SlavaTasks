package vasyurin;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Service
public class TimeRepository {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmXXX");

    private HashMap<String, TimeDto> hashMap = new HashMap<>();

    public synchronized void put(String timeString, TimeDto timeDto) {
        hashMap.put(timeString, timeDto);
        JDBC jdbc = new JDBC();
        jdbc.WriteTimeDto(timeDto);

    }

    public synchronized TimeDto getClosest(Long utcMills) {
        if (hashMap.isEmpty()) {
            return null;
        } else if (hashMap.size() == 1) {
            return hashMap.values().iterator().next();
        } else {
            return findClosest(utcMills);
        }
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
