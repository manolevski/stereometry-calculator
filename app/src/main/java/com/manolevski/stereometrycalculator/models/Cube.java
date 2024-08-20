package com.manolevski.stereometrycalculator.models;

public class Cube extends Shape {


    public Cube(ShapeType type, int imageResourceId) {
        super(type, imageResourceId);
    }

    @Override
    public void calculateVolume() {
        if (getMeasure1() > 0) {
            setVolume(Math.pow(getMeasure1(), 3));
        }
    }

    @Override
    public void calculateSurfaceArea() {
        if (getMeasure1() > 0) {
            setSurfaceArea(Math.pow(getMeasure1(), 2) * 6);
        }
    }
}
