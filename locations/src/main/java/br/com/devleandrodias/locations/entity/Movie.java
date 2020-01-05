package br.com.devleandrodias.locations.entity;

import lombok.Data;

@Data
public class Movie {

  private String nome;
  private Integer estoque;
  private Double precoLocacao;

  public Movie() {

  }

  public Movie(String nome, Integer estoque, Double precoLocacao) {
    this.nome = nome;
    this.estoque = estoque;
    this.precoLocacao = precoLocacao;
  }
}