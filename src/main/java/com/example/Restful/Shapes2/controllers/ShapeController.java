package com.example.Restful.Shapes2.controllers;

import com.example.Restful.Shapes2.controllers.models.CreateOrUpdateShape;
import com.example.Restful.Shapes2.controllers.models.ShapeModel;
import org.springframework.web.bind.annotation.*;
import com.example.Restful.Shapes2.services.ShapeService;

import java.util.List;

//@DataJpaTest


@RestController
public class ShapeController {

    private final ShapeService shapeService;

    public ShapeController(ShapeService shapeService){
        this.shapeService = shapeService;
    }

    @PostMapping("/create")
    public void create(@RequestBody CreateOrUpdateShape createOrUpdateShape){
        shapeService.create(createOrUpdateShape);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody CreateOrUpdateShape createOrUpdateShape){
        shapeService.update(id, createOrUpdateShape);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        shapeService.delete(id);
    }

    @GetMapping("/list")
    public List<ShapeModel> list(){
        return shapeService.list();
    }

    @GetMapping("/list/{id}")
    public ShapeModel listById(@PathVariable Long id){
        return shapeService.listById(id);
    }

    @GetMapping("/area/{id}")
    public Double getAreaById(@PathVariable Long id){
        return shapeService.getAreaById(id);
    }

    @GetMapping("/perimeter/{id}")
    public Double getPerimeterById(@PathVariable Long id){
        return shapeService.getPerimeterById(id);
    }



}
