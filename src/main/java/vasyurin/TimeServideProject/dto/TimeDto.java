package vasyurin.TimeServideProject.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TimeDto(String $id,
                      String currentDateTime,
                      String utcOffset,
                      Boolean isDayLightSavingsTime,
                      String dayOfTheWeek,
                      String timeZoneName,
                      Long currentFileTime,
                      String ordinalDate,
                      String serviceResponse) {

    public static TimeDtoBuilder builder() {
        return new TimeDtoBuilder();
    }

    public static final class TimeDtoBuilder {
        private String $id;
        private String currentDateTime;
        private String utcOffset;
        private Boolean isDayLightSavingsTime;
        private String dayOfTheWeek;
        private String timeZoneName;
        private Long currentFileTime;
        private String ordinalDate;
        private String serviceResponse;
        private TimeDto clone;

        private TimeDtoBuilder() {
        }

        public TimeDtoBuilder $id(String $id) {
            this.$id = $id;
            return this;
        }

        public TimeDtoBuilder currentDateTime(String currentDateTime) {
            this.currentDateTime = currentDateTime;
            return this;
        }

        public TimeDtoBuilder utcOffset(String utcOffset) {
            this.utcOffset = utcOffset;
            return this;
        }

        public TimeDtoBuilder isDayLightSavingsTime(Boolean isDayLightSavingsTime) {
            this.isDayLightSavingsTime = isDayLightSavingsTime;
            return this;
        }

        public TimeDtoBuilder dayOfTheWeek(String dayOfTheWeek) {
            this.dayOfTheWeek = dayOfTheWeek;
            return this;
        }

        public TimeDtoBuilder timeZoneName(String timeZoneName) {
            this.timeZoneName = timeZoneName;
            return this;
        }

        public TimeDtoBuilder currentFileTime(Long currentFileTime) {
            this.currentFileTime = currentFileTime;
            return this;
        }

        public TimeDtoBuilder ordinalDate(String ordinalDate) {
            this.ordinalDate = ordinalDate;
            return this;
        }

        public TimeDtoBuilder serviceResponse(String serviceResponse) {
            this.serviceResponse = serviceResponse;
            return this;
        }

        public TimeDtoBuilder clone(TimeDto clone) {
            this.clone = clone;
            return this;
        }

        public TimeDto build() {
            return new TimeDto(
                    $id == null && clone != null ? clone.$id() : $id,
                    currentDateTime == null && clone != null ? clone.currentDateTime() : currentDateTime,
                    utcOffset == null && clone != null ? clone.utcOffset() : utcOffset,
                    isDayLightSavingsTime == null && clone != null ? clone.isDayLightSavingsTime() : isDayLightSavingsTime,
                    dayOfTheWeek == null && clone != null ? clone.dayOfTheWeek() : dayOfTheWeek,
                    timeZoneName == null && clone != null ? clone.timeZoneName() : timeZoneName,
                    currentFileTime == null && clone != null ? clone.currentFileTime() : currentFileTime,
                    ordinalDate == null && clone != null ? clone.ordinalDate() : ordinalDate,
                    serviceResponse == null && clone != null ? clone.serviceResponse() : serviceResponse);
        }
    }
}
