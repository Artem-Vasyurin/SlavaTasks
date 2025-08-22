package vasyurin;

import vasyurin.apiclient.ApiClient;
import vasyurin.apiclient.ApiClientImpl;

import java.text.SimpleDateFormat;
import java.time.OffsetTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(p());
        if(true)return;
        TimeRepository timeRepository = new TimeRepository();
        ApiClient apiClient = new ApiClientImpl();
        TimeRepositoryUpdater timeRepositoryUpdater = new TimeRepositoryUpdater(timeRepository, apiClient);
        timeRepositoryUpdater.start();
        TimeController timeController = new TimeController(timeRepository);
        timeController.start();
    }

    public static boolean p() {
        List<OffsetTime> range = Stream.of("19:00-05:00/21:00-05:00")
                .map(timeRange -> timeRange.split("/"))
                .flatMap(Arrays::stream)
                .map(OffsetTime::parse)
                .toList();
        OffsetTime nowTime = OffsetTime.now();
        return nowTime.isBefore(range.getFirst()) || nowTime.isAfter(range.getLast());
    }
}