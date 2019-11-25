package com.company.Classroom;


public class Desk {

    private Dimension dimension;
    private Physical physical;

    public Desk(){
        this(new Dimension(10d,10d), new Physical("black", "steel"));
    }

    public Desk(Dimension dimension, Physical physical) {
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
}
