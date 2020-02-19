package de.interview.fizzbuzz.demo.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class WorldClock {

    private String currentDateTime;
    private String timeZoneName;

    public WorldClock(String currentDateTime, String timeZoneName) {

        this.currentDateTime = currentDateTime;
        this.timeZoneName = timeZoneName;
    }

    public String getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public String getTimeZoneName() {
        return timeZoneName;
    }

    public void setTimeZoneName(String timeZoneName) {
        this.timeZoneName = timeZoneName;
    }
}
