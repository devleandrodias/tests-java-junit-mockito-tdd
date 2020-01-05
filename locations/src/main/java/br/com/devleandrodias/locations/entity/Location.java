package br.com.devleandrodias.locations.entity;

import java.util.Date;

import lombok.Data;

/**
 * Location
 */
@Data
public class Location {

  private User usuario;
  private Movie filme;
  private Date dataLocacao;
  private Date dataRetorno;
  private Double valor;

  public Location() {

  }
}