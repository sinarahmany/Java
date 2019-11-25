package com.company.Classroom;


public class Projector implements Ielectronic{

    private boolean isOn;
    private String resolution;
    private String make;
    private String model;
    private boolean isFreeze;


    public Projector(){
        this(false, "420x420", "epson", "rx220", false);

    }

    public Projector(boolean isOn, String resolution, String make, String model, boolean isFreeze) {
        this.isOn = isOn;
        this.resolution = resolution;
        this.make = make;
        this.model = model;
    }


    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void powerOn() {
        if(!isOn){
            System.out.println("opening the projector ...");
            isOn = true;
        } else {
            System.out.println("its already on");
        }
    }

    @Override
    public void powerOff() {
        if(isOn){
            System.out.println("shutting down the projector ...");
            isOn = false;
        } else {
            System.out.println("monitor is off");
        }
    }

    public void freeze(){

        if(!isFreeze) {
            System.out.println("projector frozen");
            isFreeze = true;
        } else {
            System.out.println("projector unfrozen");
            isFreeze = true;
        }

    }

}
