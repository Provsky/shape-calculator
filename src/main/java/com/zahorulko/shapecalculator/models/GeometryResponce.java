package com.zahorulko.shapecalculator.models;

import lombok.Data;

@Data
public class GeometryResponce {

  private double area;
  private double perimeter;

  public GeometryResponce(double area, double perimeter) {
    this.area = area;
    this.perimeter = perimeter;
  }
}
