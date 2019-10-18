package com.company;

public class Box extends Square{
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    private String material;

    @Override
    public double area(){
        //super.area() = height*width; it goes back to the rectangle class and find the area and is equal to that
        return super.area()*6;
    }
    public Box (){
        material = "cardboard";
    }
    public Box(String material){
        this.material = material;
    }

}
