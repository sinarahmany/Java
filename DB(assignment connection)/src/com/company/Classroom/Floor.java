package com.company.Classroom;


public class Floor implements  Iinteract{

    private Dimension dimension;
    private Physical physical;
    private boolean isClean;

    public Floor(){
        this(new Dimension(), new Physical(), true);
    }

    public Floor(Dimension dimension, Physical physical, boolean isClean) {
        this.dimension = dimension;
        this.physical = physical;
        this.isClean = isClean;
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

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    @Override
    public boolean clean() {
        if(!isClean){
            System.out.println("cleaning the " + this.getClass().getSimpleName());
            isClean = true;
            return true;
        } else {
            System.out.println(this.getClass().getSimpleName() + " is clean");
            return isClean;
        }
    }

    @Override
    public void paint(String color) {
        System.out.println(this.getClass().getSimpleName() + " is painted to " + color);
    }

    @Override
    public boolean open() {
        System.out.println("we dont open " + this.getClass().getSimpleName());
        return false;
    }

    @Override
    public boolean close() {
        System.out.println("we dont close " + this.getClass());
        return false;
    }
}
