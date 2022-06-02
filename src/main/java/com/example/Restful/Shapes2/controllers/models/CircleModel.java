package com.example.Restful.Shapes2.controllers.models;

import com.example.Restful.Shapes2.entities.ShapeType;

public class CircleModel extends ShapeModel {
    private int radius;

    public CircleModel(){

    }

    public CircleModel(ShapeType shapeType, Double area, Double perimeter, int radius) {
        super(shapeType, area, perimeter);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
