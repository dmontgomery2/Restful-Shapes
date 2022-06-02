package com.example.Restful.Shapes2.controllers.models;

import com.example.Restful.Shapes2.entities.ShapeType;

public abstract class ShapeModel {
    private ShapeType shapeType;
    private Double area;
    private Double perimeter;

    public ShapeModel(){

    }

    public ShapeModel(ShapeType shapeType, Double area, Double perimeter) {
        this.shapeType = shapeType;
        this.area = area;
        this.perimeter = perimeter;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }
}
