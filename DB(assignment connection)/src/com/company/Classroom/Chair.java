package com.company.Classroom;

public class Chair implements Iinteract{


    private Dimension dimension;
    private Physical physical;
    private boolean isOccupied;
    private boolean isDirty;

    public Chair(){
        this.dimension = new Dimension(0,0,0);
        this.physical = new Physical("black", "metal");
        this.isOccupied = false;
        this.isDirty = false;
    }

    public Chair(Dimension dimension, Physical phical, boolean isOccupied, boolean isDirty) {
        this.dimension = dimension;
        this.physical = phical;
        this.isOccupied = isOccupied;
        this.isOccupied = isDirty;
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

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    public void sit(){

        if(!isOccupied ){
            System.out.println("you sit");
            isOccupied = true;
        } else{
            System.out.println("the chair is not empty, you can not sit");
            isOccupied = false;
        }

    }

    @Override
    public boolean clean() {

        if( isOccupied ) {
            System.out.println("sorry chair is occupied");
            return false;
        }

        if(isDirty){
            System.out.println("cleaning the chair");
            isDirty = false;
            return false;
        } else {
            System.out.println("chair is clean");
            isDirty = false;
            return isDirty;
        }
    }

    @Override
    public void paint(String color) {
        System.out.println("chair painted to " + color);
    }

    @Override
    public boolean open() {
        System.out.println("chair is not for open and close");
        return false;
    }

    @Override
    public boolean close() {
        System.out.println("chair is not for open and close");
        return false;
    }
}
