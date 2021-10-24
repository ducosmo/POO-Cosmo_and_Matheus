package Steam_zuado;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class SteamPOOHashTest {

	@Test
	void testaCadastroDeJogos() {
		SteamPOOHash sistema = new SteamPOOHash();
		Jogo jogo = new Jogo("Zelda");
		jogo.adicionaCategoria(CategoriaDeJogo.ARCADE);
		List<Jogo> jogos = new ArrayList<>();
		jogos.add(jogo);
		try {
			sistema.cadastraJogo(jogo);
		} catch (JogoJaExisteException e) {
			fail("não deveria ter lançado exceção");
		}
		assertTrue(sistema.existeJogoComNome("Zelda"));
		assertTrue(sistema.pesquisaJogosDaCategoria(CategoriaDeJogo.ARCADE).equals(jogos));
	}

	@Test
	void testPesquisaPrecoDoJogo() {
		SteamPOOHash sistema = new SteamPOOHash();
		Jogo jogo = new Jogo("Zelda");
		jogo.adicionaCategoria(CategoriaDeJogo.ARCADE);
		try {
			sistema.cadastraJogo(jogo);
		} catch (JogoJaExisteException e) {
			fail("não deveria ter lançado exceção");
		}
		try {
			double preco = sistema.pesquisaPrecoDoJogo("Zelda");
			assertEquals(0.0, preco, 0.01);
		} catch (JogoInexistenteException j) {
			fail("Não deveria dar exceção");
		}

	}

	@Test
	void testeContaJOgosDaCategoria() {
		SteamPOOHash sistema = new SteamPOOHash();
		Jogo jogo = new Jogo("Zelda");
		jogo.adicionaCategoria(CategoriaDeJogo.ARCADE);
		try {
			sistema.cadastraJogo(jogo);
		} catch (JogoJaExisteException e) {
			fail("não deveria ter lançado exceção");
		}
		assertTrue((sistema.contaJogosDaCategoria(CategoriaDeJogo.ARCADE)) == 1);
	}

	@Test
	void testAdicionaCategoriaEmJogo() {
		SteamPOOHash sistema = new SteamPOOHash();
		Jogo jogo = new Jogo("Zelda");
		try {
			sistema.cadastraJogo(jogo);
		} catch (JogoJaExisteException e) {
			fail("não deveria ter lançado exceção");
		}
		try {
			sistema.adicionaCategoriaEmJogo(jogo.getNome(), CategoriaDeJogo.ARCADE);
		} catch (JogoInexistenteException | CategoriaJaAdicionadaException e) {
			fail("não deveria ter lançado exceção");
		}
	}

}
