package Steam_zuado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SteamPOOHash implements SteamPOO {

	private Map<String, Jogo> jogos;

	public SteamPOOHash() {
		this.jogos = new HashMap<>();
	}

	@Override
	public void cadastraJogo(Jogo jogo) throws JogoJaExisteException {
		if (this.jogos.containsKey(jogo.getNome())) {
			throw new JogoJaExisteException("Já existe jogo com o nome " + jogo.getNome());
		} else {
			this.jogos.put(jogo.getNome(), jogo);
		}

	}

	@Override
	public boolean existeJogoComNome(String nomeJogo) {
		return this.jogos.containsKey(nomeJogo);
	}

	@Override
	public List<Jogo> pesquisaJogosDaCategoria(CategoriaDeJogo categoria) {
		List<Jogo> jogosDaCategoria = new ArrayList<Jogo>();
		for (Jogo j : this.jogos.values()) {
			if (j.ehDaCategoria(categoria)) {
				jogosDaCategoria.add(j);
			}
		}
		return jogosDaCategoria;
	}

	public double pesquisaPrecoDoJogo(String nome) throws JogoInexistenteException {
		if (this.jogos.containsKey(nome)) {
			return this.jogos.get(nome).getPreco();
		} else {
			throw new JogoInexistenteException("Jogo com o nome " + nome + " não existente.");
		}
	}

	public int contaJogosDaCategoria(CategoriaDeJogo categoria) {
		int valor = 0;
		for (Jogo j : this.jogos.values()) {
			if (j.ehDaCategoria(categoria)) {
				valor++;
			}
		}
		return valor;
	}

	@Override
	public void adicionaCategoriaEmJogo(String nomeJogo, CategoriaDeJogo categoria) throws JogoInexistenteException, CategoriaJaAdicionadaException{
		for(Jogo j: this.jogos.values()) {
			if(j.getNome().equals(nomeJogo)) {
				for(CategoriaDeJogo i: j.getCategorias()) {
					if(categoria.equals(i)) {
						throw new CategoriaJaAdicionadaException("Categoria ja foi adicionada");
					}
				}
				j.adicionaCategoria(categoria);
				return;
			}
		}
		throw new JogoInexistenteException("Jogo inesistente");
	}
//	@Override
//	public void adicionaCategoriaEmJogo(String nomeJogo, CategoriaDeJogo categoria) throws JogoInexistenteException {
//		Jogo j = new Jogo(nomeJogo);
//		if(this.jogos.containsKey(nomeJogo)) {
//			j.adicionaCategoria(categoria);
//		}else {
//			throw new JogoInexistenteException("Jogo inesistente");
//		}
//	}

}
