package com.zahorulko.shapecalculator.services;

import com.zahorulko.shapecalculator.models.GeometryParameters;

public enum Shape {
  RECTANGLE {
    @Override
    public double calculateArea(GeometryParameters parameters) {
      return parameters.getFirstParameter() * parameters.getSecondParameter();
    }

    @Override
    public double calculatePerimeter(GeometryParameters parameters) {
      return 2 * (parameters.getFirstParameter() + parameters.getSecondParameter());
    }
  },

  CIRCLE {
    @Override
    public double calculateArea(GeometryParameters parameters) {
      return 3.14159 * parameters.getFirstParameter() * parameters.getFirstParameter();
    }

    @Override
    public double calculatePerimeter(GeometryParameters parameters) {
      return 3.14159 * parameters.getFirstParameter() * 2;
    }
  },

  SQUARE {
    @Override
    public double calculateArea(GeometryParameters parameters) {
      return parameters.getFirstParameter() * parameters.getFirstParameter();
    }

    @Override
    public double calculatePerimeter(GeometryParameters parameters) {
      return 4 * parameters.getFirstParameter();
    }
  },

  TRIANGLE {
    @Override
    public double calculateArea(GeometryParameters parameters) {
      double perimeter =
          parameters.getFirstParameter()
              + parameters.getSecondParameter()
              + parameters.getThirdParameter();

      double s = perimeter / 2;
      double a = parameters.getFirstParameter();
      double b = parameters.getSecondParameter();
      double c = parameters.getThirdParameter();
      double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));


      return area;
    }

    @Override
    public double calculatePerimeter(GeometryParameters parameters) {
      return parameters.getFirstParameter()
          + parameters.getSecondParameter()
          + parameters.getThirdParameter();
    }
  };

  public abstract double calculateArea(GeometryParameters parameters);

  public abstract double calculatePerimeter(GeometryParameters parameters);

}
