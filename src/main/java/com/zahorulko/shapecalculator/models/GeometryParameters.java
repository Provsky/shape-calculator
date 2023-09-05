package com.zahorulko.shapecalculator.models;

import com.zahorulko.shapecalculator.services.Shape;
import lombok.Data;

@Data
public class GeometryParameters {

  private Shape shape;
  private double firstParameter;
  private double secondParameter;
  private double thirdParameter;
}
