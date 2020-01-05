package br.com.devleandrodias.locations.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.com.devleandrodias.locations.entity.Location;
import br.com.devleandrodias.locations.entity.Movie;
import br.com.devleandrodias.locations.entity.User;
import br.com.devleandrodias.locations.util.DateUtil;

/**
 * Princípios do teste
 * 
 * FIRST
 * 
 * Fast; Independent; Repeatable; Self-Verifying; Timely;
 * 
 * TestRunner que vai executar o test e coletar os resultados;
 * 
 * TestFixture pré condições necessárias para os testes;
 * 
 * TestSuites onde posso elencar os testes que srão executados;
 * 
 * TestResultFormatter quem vai padronizar os resultados dos testes;
 * 
 * Assertions verifica o estado do que está sendo testado;
 */
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
    // TODO adicionar método para salvar

    return locacao;
  }

  @Test // Especifica que isso é um teste
  public void primeiroTeste() {
    // cenário
    LocationService locacaoService = new LocationService();
    User usuario = new User("Leandro Dias");
    Movie filme = new Movie("Titanic", 2, 4.50);

    // ação

    Location localcao = locacaoService.alugarFilme(usuario, filme);

    // Assertivas

    Assert.assertTrue(localcao.getValor() == 4.50);
    Assert.assertTrue(DateUtil.isMesmaData(localcao.getDataLocacao(), new Date()));
    Assert.assertTrue(DateUtil.isMesmaData(localcao.getDataRetorno(), DateUtil.obterDataComDiferencaDias(1)));
  }
}