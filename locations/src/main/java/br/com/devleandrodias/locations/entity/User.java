package br.com.devleandrodias.locations.entity;

import java.util.Objects;

import lombok.Data;

/**
 * User
 */
@Data
public class User {

  private String name;

  public User() {

  }

  public User(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(name, user.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }
}