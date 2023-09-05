package com.zahorulko.shapecalculator.services;

import com.zahorulko.shapecalculator.models.GeometryParameters;
import com.zahorulko.shapecalculator.models.GeometryResponce;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Calculator {

  public GeometryResponce calculate(GeometryParameters parameters) {
    Shape shape = parameters.getShape();
    return new GeometryResponce(
        shape.calculateArea(parameters), shape.calculatePerimeter(parameters));
  }
}
