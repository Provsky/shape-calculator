package com.zahorulko.shapecalculator.services;

import com.zahorulko.shapecalculator.models.GeometryParameters;
import org.springframework.stereotype.Service;

@Service
public class Validation {
  public void validate(GeometryParameters parameters) {
    if (parameters.getFirstParameter() < 0
        || parameters.getShape() == Shape.RECTANGLE && parameters.getSecondParameter() < 0
        || parameters.getShape() == Shape.SQUARE && parameters.getSecondParameter() < 0
        || parameters.getShape() == Shape.TRIANGLE
            && (parameters.getSecondParameter() < 0 || parameters.getThirdParameter() < 0)) {
      throw new IllegalArgumentException();
    }
  }

  public void validateTriangleArea(double area) {
    if (Double.isNaN(area))
      throw new IllegalArgumentException("Parameters isn't match to triangle");
  }
}
