package com.company.Classroom;

public class Computer implements Ielectronic{

    private Monitor monitor;
    private String cpu;
    private String ram;
    private boolean mouse;
    private boolean keyboard;
    private boolean isOn;

    public Computer(){
        this(new Monitor(), "i3", "8gb", true, true, false);
    }

    public Computer(Monitor monitor, String cpu, String ram, boolean mouse, boolean keyboard, boolean isOn) {
        this.monitor = monitor;
        this.cpu = cpu;
        this.ram = ram;
        this.mouse = mouse;
        this.keyboard = keyboard;
        this.isOn = isOn;
    }

    @Override
    public void powerOn() {

        if(!isOn){
            System.out.println("opening the computer ...");
            isOn = true;
        } else {
            System.out.println("its already on");
        }

    }

    @Override
    public void powerOff() {
        if(isOn){
            System.out.println("shutting down the computer ...");
            isOn = false;
        } else {
            System.out.println("computer is off");
        }
    }
}
