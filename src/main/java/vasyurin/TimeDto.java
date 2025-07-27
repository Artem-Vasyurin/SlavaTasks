package main.java.vasyurin;

public class TimeDto {
    public String $id;  // поле с названием $id — так и оставим
    public String currentDateTime;
    public String utcOffset;
    public boolean isDayLightSavingsTime;
    public String dayOfTheWeek;
    public String timeZoneName;
    public long currentFileTime;
    public String ordinalDate;
    public String serviceResponse;

    @Override
    public String toString() {
        return "TimeDto{" +
                "$id='" + $id +
                ", currentDateTime='" + currentDateTime +
                ", utcOffset='" + utcOffset  +
                ", isDayLightSavingsTime=" + isDayLightSavingsTime +
                ", dayOfTheWeek='" + dayOfTheWeek  +
                ", timeZoneName='" + timeZoneName  +
                ", currentFileTime=" + currentFileTime +
                ", ordinalDate='" + ordinalDate  +
                ", serviceResponse='" + serviceResponse  +
                '}';
    }
}
