package br.com.devleandrodias.locations.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import br.com.devleandrodias.locations.entity.Location;
import br.com.devleandrodias.locations.entity.Movie;
import br.com.devleandrodias.locations.entity.User;
import br.com.devleandrodias.locations.exceptions.FilmeSemEstoqueException;
import br.com.devleandrodias.locations.exceptions.LocadoraException;
import br.com.devleandrodias.locations.util.DateUtil;

/**
 * LocationServiceTest
 */
public class LocationServiceTest {

  @Rule
  public ErrorCollector error = new ErrorCollector();

  @Rule
  public ExpectedException expection = ExpectedException.none();

  @Test
  public void primeiroTeste() throws Exception {
    // scenery
    LocationService locacaoService = new LocationService();
    User usuario = new User("Leandro Dias");
    Movie filme = new Movie("Titanic", 10, 4.50);

    // action
    Location localcao = locacaoService.alugarFilme(usuario, filme);

    // verify
    assertEquals(4.50, localcao.getValor(), 0.01);
    assertTrue(DateUtil.isMesmaData(localcao.getDataLocacao(), new Date()));
    assertTrue(DateUtil.isMesmaData(localcao.getDataRetorno(), DateUtil.obterDataComDiferencaDias(1)));
  }

  @Test(expected = FilmeSemEstoqueException.class)
  public void testLocalcaoFilmeSemEstoqueElegante() throws Exception {
    // scenery
    LocationService locacaoService = new LocationService();
    User usuario = new User("Leandro Dias");
    Movie filme = new Movie("Titanic", 0, 4.50);

    // action
    locacaoService.alugarFilme(usuario, filme);
  }

  @Test
  public void testLocalcaoFilmeSemEstoqueRobusta() {
    // scenery
    LocationService locacaoService = new LocationService();
    User usuario = new User("Leandro Dias");
    Movie filme = new Movie("Titanic", 0, 4.50);

    // action
    try {
      locacaoService.alugarFilme(usuario, filme);
      fail("deveria ter lançado uma execção");
    } catch (Exception e) {
      assertThat(e.getMessage(), is(equalTo("Filme sem estoque")));
    }
  }

  @Test
  public void testLocalcaoFilmeSemEstoqueNova() throws Exception {
    // scenery
    LocationService locacaoService = new LocationService();
    User usuario = new User("Leandro Dias");
    Movie filme = new Movie("Titanic", 0, 4.50);

    expection.expect(Exception.class);
    expection.expectMessage("Filme sem estoque");

    // action
    locacaoService.alugarFilme(usuario, filme);
  }

  @Test
  public void testLocacaoUsuarioVazio() throws FilmeSemEstoqueException {
    // scenery
    LocationService locacaoService = new LocationService();
    User usuario = new User("Leandro Dias");
    Movie filme = new Movie("Titanic", 1, 4.50);

    // action
    try {
      locacaoService.alugarFilme(null, filme);
      fail();
    } catch (LocadoraException e) {
      assertThat(e.getMessage(), is("Usuário vázio"));
    }
  }

  @Test
  public void testLocacaoFilmeVazio() throws FilmeSemEstoqueException, LocadoraException {
    // scenery
    LocationService locacaoService = new LocationService();
    User usuario = new User("Leandro Dias");
    Movie filme = new Movie("Titanic", 1, 4.50);

    expection.expect(LocadoraException.class);
    expection.expectMessage("Filme vazio");

    // action
    locacaoService.alugarFilme(usuario, null);
  }
}