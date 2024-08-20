package com.manolevski.stereometrycalculator.models;

import com.manolevski.stereometrycalculator.R;

public enum ShapeType {
    CUBE(R.string.cube),
    CUBOID(R.string.cuboid),
    PYRAMID(R.string.pyramid),
    CYLINDER(R.string.cylinder),
    CONE(R.string.cone),
    SPHERE(R.string.sphere);

    private final int resourceId;

    ShapeType(int id) {
        resourceId = id;
    }

    public int getResourceId() {
        return resourceId;
    }
}
