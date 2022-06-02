package com.example.Restful.Shapes2.controllers.models;

import com.example.Restful.Shapes2.entities.ShapeType;

public class PolygonModel extends ShapeModel {
    private int side;

    public PolygonModel(){

    }

    public PolygonModel(ShapeType shapeType, Double area, Double perimeter, int side) {
        super(shapeType, area, perimeter);
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
}
