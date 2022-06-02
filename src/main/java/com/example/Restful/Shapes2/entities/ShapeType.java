package com.example.Restful.Shapes2.entities;

public enum ShapeType {
    CIRCLE("circle"),
    SQUARE("square");

    private final String description;

    ShapeType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }



}

