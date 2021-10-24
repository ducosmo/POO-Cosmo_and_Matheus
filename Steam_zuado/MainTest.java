package Steam_zuado;



import java.util.ArrayList;
import java.util.List;

public class MainTest {
	public static void main(String [] args) {
		
		SteamPOOHash sistema = new SteamPOOHash();
		Jogo jogo = new Jogo("Zelda");
		try {
			sistema.cadastraJogo(jogo);
		}catch (JogoJaExisteException e) {
			System.out.println("falhou bonito");
		}
		try {
			sistema.adicionaCategoriaEmJogo(jogo.getNome(),CategoriaDeJogo.ARCADE);
		} catch (JogoInexistenteException | CategoriaJaAdicionadaException e) {
			System.out.println("falhou bonito");
			e.printStackTrace();
		}
		System.out.println(sistema.pesquisaJogosDaCategoria(CategoriaDeJogo.ARCADE));
		
	}

}
