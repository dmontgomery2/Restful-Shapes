package com.example.Restful.Shapes2.services;

import com.example.Restful.Shapes2.controllers.models.CreateOrUpdateShape;
import com.example.Restful.Shapes2.controllers.models.ShapeModel;
import com.example.Restful.Shapes2.domain.Shape;
import com.example.Restful.Shapes2.entities.ShapeEntity;
import com.example.Restful.Shapes2.repositories.ShapeEntityRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class ShapeService {

    private final ShapeEntityRepository shapeEntityRepository;
    private final ShapeFactory shapeFactory;

    public ShapeService(ShapeEntityRepository shapeEntityRepository, ShapeFactory shapeFactory){
        this.shapeEntityRepository = shapeEntityRepository;
        this.shapeFactory = shapeFactory;
    }

    public void create(CreateOrUpdateShape createOrUpdateShape) {
        ShapeEntity shapeEntity = new ShapeEntity();
        shapeEntity.setLength(createOrUpdateShape.getLength());
        shapeEntity.setType(createOrUpdateShape.getShapeType());
        shapeEntityRepository.save(shapeEntity);
    }

    public void update(Long id, CreateOrUpdateShape createOrUpdateShape) {
        ShapeEntity shapeEntity = getById(id);
        if(shapeEntity.getType() != createOrUpdateShape.getShapeType() || shapeEntity.getLength()
            != createOrUpdateShape.getLength()){
            shapeEntity.setPerimeter(null);
            shapeEntity.setArea(null);
        }

        shapeEntity.setLength(createOrUpdateShape.getLength());
        shapeEntity.setType(createOrUpdateShape.getShapeType());
        shapeEntityRepository.save(shapeEntity);
    }

    public void delete(Long id) {
        shapeEntityRepository.deleteById(id);
    }

    public List<ShapeModel> list() {
        List<ShapeEntity> shapeEntities = shapeEntityRepository.findAll();
        return shapeEntities.stream()
                .map(shapeFactory::getShapeModel)
                .collect(toList());
    }

    private ShapeEntity getById(Long id){
        Optional<ShapeEntity> optionalShapeEntity = shapeEntityRepository.findById(id);
        if(optionalShapeEntity.isEmpty()) throw new IllegalArgumentException("invalid id");
        return optionalShapeEntity.get();
    }

    public ShapeModel listById(Long id) {
        ShapeEntity shapeEntity = getById(id);
        return shapeFactory.getShapeModel(shapeEntity);
    }

    public double getAreaById(Long id) {
        ShapeEntity shapeEntity = getById(id);
        if(shapeEntity.getArea() == null){
            Shape shape = shapeFactory.getShape(shapeEntity);
            shapeEntity.setArea(shape.getArea());
            shapeEntityRepository.save(shapeEntity);
        }
        return shapeEntity.getArea();
    }

    public double getPerimeterById(Long id) {
        ShapeEntity shapeEntity = getById(id);
        if(shapeEntity.getPerimeter() == null){
            Shape shape = shapeFactory.getShape(shapeEntity);
            shapeEntity.setPerimeter(shape.getPerimeter());
            shapeEntityRepository.save(shapeEntity);
        }
        return shapeEntity.getPerimeter();

    }
}
