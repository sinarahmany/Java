package com.company.Classroom;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ClassRoom extends Room{

    private List<Chair> chairs;
    private List<Desk> desks;
    private List<Computer> computers;
    private Projector projector;

    public ClassRoom() {
        super();
        this.chairs = new ArrayList<>();
        this.desks = new ArrayList<>();
        this.computers = new ArrayList<>();
        this.projector = new Projector();
    }

    public ClassRoom(List<Window> windows, List<Wall> walls, List<Door> doors, Floor floor, Roof roof, double temprature, boolean isLightsOn, List<Chair> chairs, List<Desk> desks, List<Computer> computers, Projector projector) {
        super(windows, walls, doors, floor, roof, temprature, isLightsOn);
        this.chairs = chairs;
        this.desks = desks;
        this.computers = computers;
        this.projector = projector;
    }

    public List<Chair> getChairs() {
        return chairs;
    }

    public void setChairs(List<Chair> chairs) {
        this.chairs = chairs;
    }

    public List<Desk> getDesks() {
        return desks;
    }

    public void setDesks(List<Desk> desks) {
        this.desks = desks;
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }

    public Projector getProjector() {
        return projector;
    }

    public void setProjector(Projector projector) {
        this.projector = projector;
    }
}
