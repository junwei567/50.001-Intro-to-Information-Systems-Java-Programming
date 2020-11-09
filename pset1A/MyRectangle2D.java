package com.example.lib001;

public class MyRectangle2D {
    private double x;
    private double y;
    private double width;
    private double height;
    private double left_x = x - (width/2);
    private double right_x = x + (width/2);
    private double bottom_y = y - (height/2);
    private double top_y = y + (height/2);

    public MyRectangle2D(){
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.height = 1;
    }

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.left_x = x - (width/2);
        this.right_x = x + (width/2);
        this.bottom_y = y - (height/2);
        this.top_y = y + (height/2);
    }

    public double getArea(){
        return this.width * this.height;
    }

    public double getPerimeter(){
        return 2* this.width + 2* this.height;
    }

    public boolean contains(double x, double y){
        System.out.println(right_x);
        return ( (x <= this.right_x) && (this.left_x <= x) && (y <= this.top_y) && (this.bottom_y <= y) ) ;
    }

    public boolean contains(MyRectangle2D r){
        return r.right_x <= this.right_x && this.left_x <= r.left_x && r.top_y <= this.top_y && this.bottom_y <= r.bottom_y;
    }

    public boolean overlaps(MyRectangle2D r){
        return Math.abs(r.x - this.x) < this.width/2 && Math.abs(r.y - this.y) < this.height/2;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}