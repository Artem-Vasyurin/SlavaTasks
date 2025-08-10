package vasyurin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TimeDto {
    public String $id;
    public String currentDateTime;
    public String utcOffset;
    public boolean isDayLightSavingsTime;
    public String dayOfTheWeek;
    public String timeZoneName;
    public long currentFileTime;
    public String ordinalDate;
    public String serviceResponse;
    public long unixDateTime;

    TimeDto(){}

    @Override
    public String toString() {
        return "TimeDto{" +
                "$id='" + $id +
                ", currentDateTime='" + currentDateTime +
                ", utcOffset='" + utcOffset +
                ", isDayLightSavingsTime=" + isDayLightSavingsTime +
                ", dayOfTheWeek='" + dayOfTheWeek +
                ", timeZoneName='" + timeZoneName +
                ", currentFileTime=" + currentFileTime +
                ", ordinalDate='" + ordinalDate +
                ", serviceResponse='" + serviceResponse +
                ", unixDateTime='" + unixDateTime +
                '}';
    }

}
