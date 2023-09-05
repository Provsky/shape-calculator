package com.zahorulko.shapecalculator.controllers;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.zahorulko.shapecalculator.models.GeometryParameters;
import com.zahorulko.shapecalculator.models.GeometryResponce;
import com.zahorulko.shapecalculator.services.Calculator;
import com.zahorulko.shapecalculator.services.Validation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainController {

  private Calculator calculator;
  private Validation validation;

  @PostMapping("/calculate")
  public ResponseEntity<GeometryResponce> calculate(@RequestBody GeometryParameters parameters) {
    validation.validate(parameters);
    GeometryResponce responce = calculator.calculate(parameters);
    validation.validateTriangleArea(responce.getArea());
    return ResponseEntity.ok(responce);
  }

  @ExceptionHandler
  public String handleBadParameters(IllegalArgumentException e) {
    return "Illegal parameters, impossible to calculate anything with such parameters ";
  }

  @ExceptionHandler
  public String handleBadShape(InvalidFormatException a) {
    return "Look's like you have mistake at wright shape, we have such allowed shapes [ RECTANGLE, TRIANGLE, CIRCLE, SQUARE ] ";
  }
}
