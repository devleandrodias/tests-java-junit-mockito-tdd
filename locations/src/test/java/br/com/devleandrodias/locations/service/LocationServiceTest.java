package br.com.devleandrodias.locations.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.com.devleandrodias.locations.entity.Location;
import br.com.devleandrodias.locations.entity.Movie;
import br.com.devleandrodias.locations.entity.User;
import br.com.devleandrodias.locations.util.DateUtil;

/**
 * LocationServiceTest
 */
public class LocationServiceTest {

  @Test
  public void primeiroTeste() {
    LocationService locacaoService = new LocationService();
    User usuario = new User("Leandro Dias");
    Movie filme = new Movie("Titanic", 2, 4.50);

    Location localcao = locacaoService.alugarFilme(usuario, filme);

    Assert.assertTrue(localcao.getValor() == 4.50);
    Assert.assertTrue(DateUtil.isMesmaData(localcao.getDataLocacao(), new Date()));
    Assert.assertTrue(DateUtil.isMesmaData(localcao.getDataRetorno(), DateUtil.obterDataComDiferencaDias(1)));
  }
}