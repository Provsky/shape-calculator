package com.zahorulko.shapecalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.zahorulko.shapecalculator.models.GeometryParameters;
import com.zahorulko.shapecalculator.models.GeometryResponce;
import com.zahorulko.shapecalculator.services.Calculator;
import com.zahorulko.shapecalculator.services.Shape;
import org.junit.jupiter.api.Test;

class CalculatorTests {

  private final Calculator calculator = new Calculator();

  @Test
  void calculateRectangle() {
    GeometryParameters parameters = new GeometryParameters();
    parameters.setShape(Shape.RECTANGLE);
    parameters.setFirstParameter(4);
    parameters.setSecondParameter(1);

    GeometryResponce responce = calculator.calculate(parameters);

    assertEquals(4, responce.getArea());
    assertEquals(10, responce.getPerimeter());
  }

  @Test
  void calculateSquare() {
    GeometryParameters parameters = new GeometryParameters();
    parameters.setShape(Shape.SQUARE);
    parameters.setFirstParameter(4);

    GeometryResponce responce = calculator.calculate(parameters);

    assertEquals(16, responce.getArea());
    assertEquals(16, responce.getPerimeter());
  }

  @Test
  void calculateTriangle() {
    GeometryParameters parameters = new GeometryParameters();
    parameters.setShape(Shape.TRIANGLE);
    parameters.setFirstParameter(5);
    parameters.setSecondParameter(4);
    parameters.setThirdParameter(3);

    GeometryResponce responce = calculator.calculate(parameters);

    assertEquals(6, responce.getArea());
    assertEquals(12, responce.getPerimeter());
  }

  @Test
  void calculateCircle() {
    GeometryParameters parameters = new GeometryParameters();
    parameters.setShape(Shape.CIRCLE);
    parameters.setFirstParameter(5);

    GeometryResponce responce = calculator.calculate(parameters);

    assertEquals(78.53975, responce.getArea());
    assertEquals(31.4159, responce.getPerimeter());
  }
}
