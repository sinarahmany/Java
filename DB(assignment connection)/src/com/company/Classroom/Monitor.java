package com.company.Classroom;


public class Monitor implements Ielectronic, Iinteract {

    private String resolution;
    private boolean isOn;
    private boolean isClean;

    public Monitor(){
        this("800x600", false,true);
    }

    public Monitor(String resolution, boolean isOn, boolean isClean) {
        this.resolution = resolution;
        this.isOn = isOn;
        this.isClean = isClean;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    @Override
    public void powerOn() {
        if(!isOn){
            System.out.println("opening the monitor ...");
            isOn = true;
        } else {
            System.out.println("its already on");
        }
    }

    @Override
    public void powerOff() {
        if(isOn){
            System.out.println("shutting down the monitor ...");
            isOn = false;
        } else {
            System.out.println("monitor is off");
        }
    }

    @Override
    public boolean clean() {
        if(!isClean){
            System.out.println("cleaning the monitor");
            isClean = true;
            return true;
        } else {
            System.out.println("monitor is clean");
            return isClean;
        }
    }

    @Override
    public void paint(String color) {
        System.out.println("we dont pain monitor");
    }

    @Override
    public boolean open() {
        System.out.println("we dont open monitor");
        return false;
    }

    @Override
    public boolean close() {
        System.out.println("we dont close monitor");
        return false;
    }
}
