package com.example.Restful.Shapes2.services;

import com.example.Restful.Shapes2.controllers.models.CircleModel;
import com.example.Restful.Shapes2.controllers.models.PolygonModel;
import com.example.Restful.Shapes2.controllers.models.ShapeModel;
import com.example.Restful.Shapes2.entities.ShapeEntity;
import com.example.Restful.Shapes2.domain.Circle;
import com.example.Restful.Shapes2.domain.Shape;
import com.example.Restful.Shapes2.domain.Square;
import org.springframework.stereotype.Service;

@Service
public class ShapeFactory {

    public Shape getShape(ShapeEntity shapeEntity){
        switch(shapeEntity.getType()){
            case CIRCLE:
                return new Circle(shapeEntity.getLength());
            case SQUARE:
                return new Square(shapeEntity.getLength());
            default:
                throw new IllegalArgumentException("invalid shape type");
        }

    }

    public ShapeModel getShapeModel(ShapeEntity shapeEntity){
        switch(shapeEntity.getType()){
            case CIRCLE:
                return new CircleModel(shapeEntity.getType(), shapeEntity.getArea(), shapeEntity.getPerimeter(),
                        shapeEntity.getLength());
            case SQUARE:
                return new PolygonModel(shapeEntity.getType(), shapeEntity.getArea(), shapeEntity.getPerimeter(),
                        shapeEntity.getLength());
            default:
                throw new IllegalArgumentException("invalid shape type");
        }

    }

}
