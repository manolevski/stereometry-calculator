package com.manolevski.stereometrycalculator.models;

public class Cylinder extends Shape {


    public Cylinder(ShapeType type, int imageResourceId) {
        super(type, imageResourceId);
    }

    @Override
    public void calculateVolume() {
        if (getMeasure1() > 0 && getMeasure2() > 0) {
            double r = getMeasure1();
            double h = getMeasure2();
            setVolume(h * Math.PI * r * r);
        }
    }

    @Override
    public void calculateSurfaceArea() {
        if (getMeasure1() > 0 && getMeasure2() > 0) {
            double r = getMeasure1();
            double h = getMeasure2();
            setSurfaceArea(2 * Math.PI * r * (r + h));
        }
    }
}
