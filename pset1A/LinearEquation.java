package com.example.lib001;

public class LinearEquation {

    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double determinant;
    private double Dx;
    private double Dy;
    private double X;
    private double Y;

    // ax + by = e
    // cx + dy = f

    public LinearEquation() {
        this.a = 1;
    }

    public LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;

        //cramers rule
        this.determinant = this.a * this.d - this.b * this.c;
        this.Dx = this.e * this.d - this.b * this.f;
        this.Dy = this.a * this.f - this.e * this.c;

    }

    public double getA() {
        return this.a;
    }
    public double getB() {
        return this.b;
    }
    public double getC() {
        return this.c;
    }
    public double getD() {
        return this.d;
    }
    public double getE() {
        return this.e;
    }
    public double getF() {
        return this.f;
    }

    public boolean isSolvable() {
        if (this.determinant != 0) return true;
        else return false;
    }

    public double getX() {
        this.X = this.Dx / this.determinant;
        return this.X;
    }

    public double getY() {
        this.Y = this.Dy / this.determinant;
        return this.Y;
    }

}

