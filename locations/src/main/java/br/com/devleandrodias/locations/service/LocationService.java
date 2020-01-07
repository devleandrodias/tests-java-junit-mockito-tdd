package br.com.devleandrodias.locations.service;

import java.util.Date;

import br.com.devleandrodias.locations.entity.Location;
import br.com.devleandrodias.locations.entity.Movie;
import br.com.devleandrodias.locations.entity.User;
import br.com.devleandrodias.locations.exceptions.FilmeSemEstoqueException;
import br.com.devleandrodias.locations.exceptions.LocadoraException;
import br.com.devleandrodias.locations.util.DateUtil;

public class LocationService {

  public Location alugarFilme(User usuario, Movie movie) throws FilmeSemEstoqueException, LocadoraException {

    if (usuario == null)
      throw new LocadoraException("Usuário Vázio");

    if (movie == null)
      throw new LocadoraException("Filme vazio");

    if (movie.getQuantity() == 0)
      throw new FilmeSemEstoqueException();

    Location location = new Location();

    location.setFilme(movie);
    location.setUser(usuario);
    location.setDataLocacao(new Date());
    location.setValor(movie.getPriceLocation());

    Date dataEntrega = new Date();

    dataEntrega = DateUtil.adicionarDias(dataEntrega, 1);

    location.setDataRetorno(dataEntrega);

    return location;
  }
}