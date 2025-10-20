package vasyurin.TimeServideProject.repositories;

import org.springframework.stereotype.Service;
import vasyurin.TimeServideProject.dto.TimeDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TimeRepository {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmXXX");
    {
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-4"));
    }

    private Map<String, TimeDto> hashMap = new ConcurrentHashMap<>();

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
                    long diff1 = Math.abs(closestKey.getTime() - userDate.getTime());
                    long diff2 = Math.abs(keyDate.getTime() - userDate.getTime());

                    if (diff2 < diff1) {
                        closestKey = keyDate;
                    }
                }
            }
            System.out.println(dateFormat.format(closestKey));
            return hashMap.get(dateFormat.format(closestKey));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


}
