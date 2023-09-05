package com.zahorulko.shapecalculator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.zahorulko.shapecalculator.models.GeometryParameters;
import com.zahorulko.shapecalculator.models.GeometryResponce;
import com.zahorulko.shapecalculator.services.Calculator;
import com.zahorulko.shapecalculator.services.Shape;
import com.zahorulko.shapecalculator.services.Validation;
import org.junit.jupiter.api.Test;

public class ValidationTest {
  private final Validation validation = new Validation();
  private final Calculator calculator = new Calculator();

  @Test
  void validateWrongFirstParameter() {
    GeometryParameters parameters = new GeometryParameters();
    parameters.setShape(Shape.RECTANGLE);
    parameters.setFirstParameter(-1);
    parameters.setSecondParameter(1);

    assertThrows(
        IllegalArgumentException.class,
        () -> {
          validation.validate(parameters);
        });
  }

  @Test
  void validateWrongSecondParameterForRectangle() {
    GeometryParameters parameters = new GeometryParameters();
    parameters.setShape(Shape.RECTANGLE);
    parameters.setFirstParameter(1);
    parameters.setSecondParameter(-1);

    assertThrows(
        IllegalArgumentException.class,
        () -> {
          validation.validate(parameters);
        });
  }

  @Test
  void validateWrongSecondParameterForSquare() {
    GeometryParameters parameters = new GeometryParameters();
    parameters.setShape(Shape.SQUARE);
    parameters.setFirstParameter(1);
    parameters.setSecondParameter(-1);

    assertThrows(
        IllegalArgumentException.class,
        () -> {
          validation.validate(parameters);
        });
  }

  @Test
  void validateWrongSecondParameterForTriangle() {
    GeometryParameters parameters = new GeometryParameters();
    parameters.setShape(Shape.TRIANGLE);
    parameters.setFirstParameter(1);
    parameters.setSecondParameter(-1);

    assertThrows(
        IllegalArgumentException.class,
        () -> {
          validation.validate(parameters);
        });
  }

  @Test
  void validateWrongThirdParameterForTriangle() {
    GeometryParameters parameters = new GeometryParameters();
    parameters.setShape(Shape.TRIANGLE);
    parameters.setFirstParameter(1);
    parameters.setSecondParameter(1);
    parameters.setThirdParameter(-1);

    assertThrows(
        IllegalArgumentException.class,
        () -> {
          validation.validate(parameters);
        });
  }

  @Test
  void validateNotAcceptableParametersForTriangle() {
    GeometryParameters parameters = new GeometryParameters();
    parameters.setShape(Shape.TRIANGLE);
    parameters.setFirstParameter(10);
    parameters.setSecondParameter(1);
    parameters.setThirdParameter(1);

    GeometryResponce responce = calculator.calculate(parameters);

    assertThrows(
        IllegalArgumentException.class,
        () -> {
          validation.validateTriangleArea(responce.getArea());
        });
  }
}
