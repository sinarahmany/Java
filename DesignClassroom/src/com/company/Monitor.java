package com.company;

public class Monitor {
    private String resolution;

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public boolean isInOn() {
        return inOn;
    }

    public void setInOn(boolean inOn) {
        this.inOn = inOn;
    }

    private boolean inOn;
}
