package com.manolevski.stereometrycalculator.models;

public class Sphere extends Shape {


    public Sphere(ShapeType type, int imageResourceId) {
        super(type, imageResourceId);
    }

    @Override
    public void calculateVolume() {
        if (getMeasure1() > 0) {
            double r = getMeasure1();
            setVolume((4 * Math.PI * Math.pow(r, 3)) / 3);
        }
    }

    @Override
    public void calculateSurfaceArea() {
        if (getMeasure1() > 0) {
            double r = getMeasure1();
            setSurfaceArea(4 * Math.PI * Math.pow(r, 2));
        }
    }
}
