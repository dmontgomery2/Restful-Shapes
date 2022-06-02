package com.example.Restful.Shapes2.controllers.models;

import com.example.Restful.Shapes2.entities.ShapeType;

public class CreateOrUpdateShape {

    private ShapeType shapeType;
    private Integer side;
    private Integer radius;

    public ShapeType getShapeType() {
        return shapeType;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public Integer getSide() {
        return side;
    }

    public void setSide(Integer side) {
        this.side = side;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public Integer getLength(){
        if(side != null && radius != null) throw new IllegalStateException("shape has side and radius");
        if(side == null && radius == null) throw new IllegalStateException("shape has null side and null radius");
        if(side != null) return side;
        return radius;
    }
}
