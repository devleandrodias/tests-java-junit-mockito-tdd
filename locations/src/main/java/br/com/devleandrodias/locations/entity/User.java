package br.com.devleandrodias.locations.entity;

import lombok.Data;

/**
 * User
 */
@Data
public class User {

  private String nome;

  public User() {

  }

  public User(String nome) {
    this.nome = nome;
  }
}