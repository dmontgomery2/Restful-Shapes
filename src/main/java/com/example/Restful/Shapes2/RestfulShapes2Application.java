package com.example.Restful.Shapes2;

import com.example.Restful.Shapes2.domain.Circle;
import com.example.Restful.Shapes2.domain.Shape;
import com.example.Restful.Shapes2.domain.Square;
import com.example.Restful.Shapes2.entities.ShapeEntity;
import com.example.Restful.Shapes2.entities.ShapeType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.example.Restful.Shapes2.repositories.ShapeEntityRepository;
import org.springframework.context.annotation.Bean;


//@JsonCreator - https://stackoverflow.com/questions/12468764/jackson-enum-serializing-and-deserializer



@SpringBootApplication
public class RestfulShapes2Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(RestfulShapes2Application.class, args);
		ShapeEntityRepository shapeEntityRepository =
				configurableApplicationContext.getBean(ShapeEntityRepository.class);
		ShapeEntity circle = new ShapeEntity();
		ShapeEntity square = new ShapeEntity();
		circle.setType(ShapeType.CIRCLE);
		circle.setLength(5);
		square.setType(ShapeType.SQUARE);
		square.setLength(10);
		shapeEntityRepository.save(circle);
		shapeEntityRepository.save(square);
	}

	@Bean
	public ObjectMapper objectMapper(){
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return new ObjectMapper(); }

}
