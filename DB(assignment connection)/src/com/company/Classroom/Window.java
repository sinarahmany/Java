package com.company.Classroom;

public class Window implements Iinteract{

    private Dimension dimension;
    private boolean isOpen;
    private boolean isDirty;
    private boolean isOpac;

    public Window(){

    }

    public Window(Dimension dimension, boolean isOpen, boolean isDirty, boolean isOpac) {
        this.dimension = dimension;
        this.isOpen = isOpen;
        this.isDirty = isDirty;
        this.isOpac = isOpac;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    public boolean isOpac() {
        return isOpac;
    }

    public void setOpac(boolean opac) {
        isOpac = opac;
    }

    @Override
    public boolean clean() {
        System.out.println("window is cleaning");
        return !isDirty;
    }

    @Override
    public void paint(String color) {
        System.out.println("I can not ");
    }

    @Override
    public boolean open() {
        return isOpen;
    }

    @Override
    public boolean close() {
        return !isOpen;
    }
}
