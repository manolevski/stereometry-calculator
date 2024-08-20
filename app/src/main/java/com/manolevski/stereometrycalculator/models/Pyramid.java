package com.manolevski.stereometrycalculator.models;

public class Pyramid extends Shape {


    public Pyramid(ShapeType type, int imageResourceId) {
        super(type, imageResourceId);
    }

    @Override
    public void calculateVolume() {
        if (getMeasure1() > 0 && getMeasure2() > 0) {
            double a = getMeasure1();
            double h = getMeasure2();
            setVolume((a * a * h) / 3);
        }
    }

    @Override
    public void calculateSurfaceArea() {
        if (getMeasure1() > 0 && getMeasure2() > 0) {
            double a = getMeasure1();
            double h = getMeasure2();
            setSurfaceArea((a * a) + (a * Math.sqrt((a * a) + (4 * h * h))));
        }
    }
}
