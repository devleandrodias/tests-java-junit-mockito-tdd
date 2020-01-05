package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;

import java.util.Date;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

/**
 * Princípios do teste
 * 
 * FIRST
 * 
 * Fast; Independent; Repeatable; Self-Verifying; Timely
 */

public class LocacaoService {

	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		// Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);

		// Salvando a locacao...
		// TODO adicionar método para salvar

		return locacao;
	}

	public static void main(String[] args) {
		// cenário
		LocacaoService locacaoService = new LocacaoService();
		Usuario usuario = new Usuario("Leandro Dias");
		Filme filme = new Filme("Titanic", 2, 4.50);

		// ação

		Locacao localcao = locacaoService.alugarFilme(usuario, filme);

		// verificação

		System.out.println(localcao.getValor() == 4.50);
		System.out.println(DataUtils.isMesmaData(localcao.getDataLocacao(), new Date()));
		System.out.println(DataUtils.isMesmaData(localcao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	}
}