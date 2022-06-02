package com.example.Restful.Shapes2.repositories;

import com.example.Restful.Shapes2.domain.Shape;
import com.example.Restful.Shapes2.entities.ShapeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShapeEntityRepository extends JpaRepository<ShapeEntity, Long> {

}
