package com.company.Classroom;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private List<Window> windows;
    private List<Wall> walls;
    private List<Door> doors;
    private Floor floor;
    private Roof roof;
    private double temprature;
    private boolean isLightsOn;

    public Room(){
        this.windows = new ArrayList<Window>();
        this.windows.add(new Window(new Dimension(25,25), false, false, true));
        this.walls = new ArrayList<Wall>();
        this.doors = new ArrayList<Door>();
        this.floor = new Floor();
        this.roof = new Roof();
        this.temprature = 25.0d;
        this.isLightsOn = false;
    }

    public Room(List<Window> windows, List<Wall> walls, List<Door> doors, Floor floor, Roof roof, double temprature, boolean isLightsOn) {
        this.windows = windows;
        this.walls = walls;
        this.doors = doors;
        this.floor = floor;
        this.roof = roof;
        this.temprature = temprature;
        this.isLightsOn = isLightsOn;
    }

    public List<Window> getWindows() {
        return windows;
    }

    public void setWindows(List<Window> windows) {
        this.windows = windows;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Roof getRoof() {
        return roof;
    }

    public void setRoof(Roof roof) {
        this.roof = roof;
    }

    public double getTemprature() {
        return temprature;
    }

    public void setTemprature(double temprature) {
        this.temprature = temprature;
    }

    public boolean isLightsOn() {
        return isLightsOn;
    }

    public void setLightsOn(boolean lightsOn) {
        isLightsOn = lightsOn;
    }
}
