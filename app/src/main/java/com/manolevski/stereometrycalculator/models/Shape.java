package com.manolevski.stereometrycalculator.models;

public abstract class Shape {

    private ShapeType type;
    private int imageResourceId;
    private double measure1;
    private double measure2;
    private double measure3;
    private String measure1Name;
    private String measure2Name;
    private String measure3Name;

    private double surfaceArea;

    protected Shape(ShapeType type, int imageResourceId) {
        this.type = type;
        this.imageResourceId = imageResourceId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setMeasure1(double measure1) {
        this.measure1 = measure1;
    }

    public void setMeasure2(double measure2) {
        this.measure2 = measure2;
    }

    public void setMeasure3(double measure3) {
        this.measure3 = measure3;
    }

    public double getMeasure1() {
        return measure1;
    }

    public double getMeasure2() {
        return measure2;
    }

    public double getMeasure3() {
        return measure3;
    }

    public String getMeasure1Name() {
        return measure1Name;
    }

    public void setMeasure1Name(String measure1Name) {
        this.measure1Name = measure1Name;
    }

    public String getMeasure2Name() {
        return measure2Name;
    }

    public void setMeasure2Name(String measure2Name) {
        this.measure2Name = measure2Name;
    }

    public String getMeasure3Name() {
        return measure3Name;
    }

    public void setMeasure3Name(String measure3Name) {
        this.measure3Name = measure3Name;
    }

    private double volume;

    public double getVolume() {
        return volume;
    }

    protected void setVolume(double volume) {
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    protected void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public abstract void calculateVolume();
    public abstract void calculateSurfaceArea();
}
