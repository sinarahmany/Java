package com.company;

public class Window implements Iinteract{
    private double height;
    private double width;
    private boolean isOpen;
    private boolean isClean;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public boolean clean() {
        return isClean=true;
    }

    @Override
    public void paint(String color) {
        System.out.println("UMM! painting the window what an intresting idea!!");
    }

    @Override
    public boolean open() {
        return isOpen=true;
    }

    @Override
    public boolean close() {
        return isOpen=false;
    }
}
