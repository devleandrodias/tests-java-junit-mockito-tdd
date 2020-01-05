package br.com.devleandrodias.locations.service;

import java.util.Date;

import br.com.devleandrodias.locations.entity.Location;
import br.com.devleandrodias.locations.entity.Movie;
import br.com.devleandrodias.locations.entity.User;
import br.com.devleandrodias.locations.util.DateUtil;

public class LocationService {

  public Location alugarFilme(User usuario, Movie filme) {
    Location locacao = new Location();
    locacao.setFilme(filme);
    locacao.setUsuario(usuario);
    locacao.setDataLocacao(new Date());
    locacao.setValor(filme.getPrecoLocacao());

    // Entrega no dia seguinte
    Date dataEntrega = new Date();
    dataEntrega = DateUtil.adicionarDias(dataEntrega, 1);
    locacao.setDataRetorno(dataEntrega);

    // Salvando a locacao...

    return locacao;
  }
}