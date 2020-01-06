package br.com.devleandrodias.locations.entity;

import lombok.Data;

@Data
public class Movie {

  private String name;
  private Integer quantity;
  private Double priceLocation;

  public Movie() {

  }

  public Movie(String name, Integer quantity, Double priceLocation) {
    this.name = name;
    this.quantity = quantity;
    this.priceLocation = priceLocation;
  }
}