package br.com.devleandrodias.locations.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.com.devleandrodias.locations.entity.Location;
import br.com.devleandrodias.locations.entity.Movie;
import br.com.devleandrodias.locations.entity.User;
import br.com.devleandrodias.locations.util.DateUtil;

/**
 * LocationServiceTest
 */
public class LocationServiceTest {

  @Rule
  public ErrorCollector error = new ErrorCollector();

  @Test
  public void primeiroTeste() {
    LocationService locacaoService = new LocationService();
    User usuario = new User("Leandro Dias");
    Movie filme = new Movie("Titanic", 2, 4.50);

    Location localcao = locacaoService.alugarFilme(usuario, filme);

    assertEquals(4.50, localcao.getValor(), 0.01);
    assertTrue(DateUtil.isMesmaData(localcao.getDataLocacao(), new Date()));
    assertTrue(DateUtil.isMesmaData(localcao.getDataRetorno(), DateUtil.obterDataComDiferencaDias(1)));
  }
}