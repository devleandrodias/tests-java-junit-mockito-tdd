package br.com.devleandrodias.locations.service;

import java.util.Date;

import br.com.devleandrodias.locations.entity.Location;
import br.com.devleandrodias.locations.entity.Movie;
import br.com.devleandrodias.locations.entity.User;
import br.com.devleandrodias.locations.util.DateUtil;

public class LocationService {

  public Location alugarFilme(User usuario, Movie filme) {
    Location location = new Location();

    location.setFilme(filme);
    location.setUser(usuario);
    location.setDataLocacao(new Date());
    location.setValor(filme.getPrecoLocacao());

    // Entrega no dia seguinte
    Date dataEntrega = new Date();
    dataEntrega = DateUtil.adicionarDias(dataEntrega, 1);
    location.setDataRetorno(dataEntrega);

    // Salvando a locacao...

    return location;
  }
}