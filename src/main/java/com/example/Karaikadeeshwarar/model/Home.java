package com.example.Karaikadeeshwarar.model;

public class Home {

    private String templeName;
    private String location;
    private String history;
    //private String timings;

    public Home() {
    }

    public Home(String templeName, String location,
                String history) {
        this.templeName = templeName;
        this.location = location;
        this.history = history;
        //this.timings = timings;
    }

    public String getTempleName() {
        return templeName;
    }

    public void setTempleName(String templeName) {
        this.templeName = templeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

//    public String getTimings() {
//        return timings;
//    }
//
//    public void setTimings(String timings) {
//        this.timings = timings;
//    }
}
