package com.example.lib001;
import java.lang.*;

public class Triangle extends GeometricObject {

    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;
    private double p;
    private double area;
    private String color = "None";
    private boolean isFilled = false;

    public Triangle() {
        this.side1 = 1;
        this.side2 = 1;
        this.side3 = 1;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getArea() {
        this.p = (this.side1 + this.side2 + this.side3) / 2;
        this.area = Math.sqrt(this.p * (this.p - this.side1) * (this.p - this.side2) * (this.p - this.side3));
        return this.area;
    }

    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

//    @Override
    public String toString() {
        return "Triangle:" +
                " side1 = " + side1 +
                " side2 = " + side2 +
                " side3 = " + side3;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean t) {
        this.isFilled = t;
    }

    public boolean isFilled() {
        if (this.isFilled == false) return false;
        else return true;
    }
}
