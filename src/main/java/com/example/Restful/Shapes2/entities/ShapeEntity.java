package com.example.Restful.Shapes2.entities;

import javax.persistence.*;

@Entity
public class ShapeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "length", nullable = false)
    private int length;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ShapeType type;

    @Column(name = "perimeter")
    private Double perimeter;

    @Column(name = "area")
    private Double area;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ShapeType getType() {
        return type;
    }

    public void setType(ShapeType type) {
        this.type = type;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}
