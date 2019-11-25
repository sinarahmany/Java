package com.company.Classroom;


public class Wall implements  Iinteract{

    private Dimension dimension;
    private Physical physical;

    public Wall() {
        this(new Dimension(), new Physical());
    }

    public Wall(Dimension dimension, Physical physical) {
        this.dimension = dimension;
        this.physical = physical;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Physical getPhysical() {
        return physical;
    }

    public void setPhysical(Physical physical) {
        this.physical = physical;
    }

    @Override
    public boolean clean() {
        System.out.println("wall is cleaned");
        return false;
    }

    @Override
    public void paint(String color) {
        System.out.println("wall painted to " + color);

    }

    @Override
    public boolean open() {
        System.out.println("wall can not be opened");
        return false;
    }

    @Override
    public boolean close() {
        System.out.println("wall can not be closed");
        return false;
    }
}
