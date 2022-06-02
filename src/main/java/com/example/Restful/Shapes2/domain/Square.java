package com.example.Restful.Shapes2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Square implements Shape{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private static final int NUM_SIDES = 4;
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return Math.pow(side, 2);
    }

    @Override
    public double getPerimeter() {
        return NUM_SIDES * side;
    }
}
