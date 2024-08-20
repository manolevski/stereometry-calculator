package com.manolevski.stereometrycalculator.models;

public class Cone extends Shape {


    public Cone(ShapeType type, int imageResourceId) {
        super(type, imageResourceId);
    }

    @Override
    public void calculateVolume() {
        if (getMeasure1() > 0 && getMeasure2() > 0) {
            double r = getMeasure1();
            double h = getMeasure2();
            setVolume((Math.PI * r * r * h) / 3);
        }
    }

    @Override
    public void calculateSurfaceArea() {
        if (getMeasure1() > 0 && getMeasure2() > 0) {
            double r = getMeasure1();
            double h = getMeasure2();
            setSurfaceArea(Math.PI * r * (r + Math.sqrt((h * h) + (r * r))));
        }
    }
}
