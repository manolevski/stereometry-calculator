package com.manolevski.stereometrycalculator.models;

public class Cuboid extends Shape {


    public Cuboid(ShapeType type, int imageResourceId) {
        super(type, imageResourceId);
    }

    @Override
    public void calculateVolume() {
        if (getMeasure1() > 0 && getMeasure2() > 0 && getMeasure3() > 0) {
            double a = getMeasure1();
            double b = getMeasure2();
            double c = getMeasure3();
            setVolume(a * b * c);
        }
    }

    @Override
    public void calculateSurfaceArea() {
        if (getMeasure1() > 0 && getMeasure2() > 0 && getMeasure3() > 0) {
            double a = getMeasure1();
            double b = getMeasure2();
            double c = getMeasure3();
            setSurfaceArea(2 * (a * b + a * c + b * c));
        }
    }
}
