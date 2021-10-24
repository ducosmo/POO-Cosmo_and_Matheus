package Steam_zuado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CadastraJogoController implements ActionListener {
	private SteamPOO sistema;
	private JFrame janelaPrincipal;
	
	public CadastraJogoController(SteamPOO sistema, JFrame janelaPrincipal) {
		this.sistema = sistema;
		this.janelaPrincipal = janelaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		SteamPOOHash sistema = new SteamPOOHash();
		String nome = JOptionPane.showInputDialog(janelaPrincipal, "Insira o nome do jogo: ");
		double preco = Double.parseDouble(JOptionPane.showInputDialog(janelaPrincipal, "Insira o valor: "));
		Jogo jogo = new Jogo(nome);
		jogo.setPreco(preco);
		try {
			sistema.cadastraJogo(jogo);
		} catch (JogoJaExisteException e2) {
			JOptionPane.showMessageDialog(null, "Jogo ja existente.");
			e2.printStackTrace();
			return;
		}
		boolean continuar = true;
		do {
			String valor = JOptionPane.showInputDialog(janelaPrincipal,"~Escolha as categorias para o jogo digitando o numero correspondente~ \n"
				+ "1-AVENTURA\n"
				+ "2-TERROR\n"
				+ "3-ARCADE\n"
				+ "4-GUERRA\n"
				+ "5-CORRIDA\n"
				+ "6-AÇÃO\n"
				+ "7-LUTA\n"
				+ "8-Concluir");
			
			switch(valor) {
			case "1":
				try {
					sistema.adicionaCategoriaEmJogo(jogo.getNome(), CategoriaDeJogo.AVENTURA);
				} catch (JogoInexistenteException | CategoriaJaAdicionadaException e2) {
					JOptionPane.showMessageDialog(null, "Categoria ja adicionada");
					e2.printStackTrace();
				}
				break;
			case "2":
				try {
					sistema.adicionaCategoriaEmJogo(jogo.getNome(), CategoriaDeJogo.TERROR);
				} catch (JogoInexistenteException | CategoriaJaAdicionadaException e2) {
					JOptionPane.showMessageDialog(null, "Categoria ja adicionada");
					e2.printStackTrace();
				}
				break;
			case "3":
				try {
					sistema.adicionaCategoriaEmJogo(jogo.getNome(), CategoriaDeJogo.ARCADE);
				} catch (JogoInexistenteException | CategoriaJaAdicionadaException e2) {
					JOptionPane.showMessageDialog(null, "Categoria ja adicionada");
					e2.printStackTrace();
				}
				break;
			case "4":
				try {
					sistema.adicionaCategoriaEmJogo(jogo.getNome(),CategoriaDeJogo.GUERRA);
				} catch (JogoInexistenteException | CategoriaJaAdicionadaException e2) {
					JOptionPane.showMessageDialog(null, "Categoria ja adicionada");
					e2.printStackTrace();
				}
				break;
			case "5":
				try {
					sistema.adicionaCategoriaEmJogo(jogo.getNome(),CategoriaDeJogo.CORRIDA);
				} catch (JogoInexistenteException | CategoriaJaAdicionadaException e2) {
					JOptionPane.showMessageDialog(null, "Categoria ja adicionada");
					e2.printStackTrace();
				}
				break;
			case "6":
				try {
					sistema.adicionaCategoriaEmJogo(jogo.getNome(),CategoriaDeJogo.ACAO);
				} catch (JogoInexistenteException | CategoriaJaAdicionadaException e2) {
					JOptionPane.showMessageDialog(null, "Categoria ja adicionada");
					e2.printStackTrace();
				}
				break;
			case "7":
				try {
					sistema.adicionaCategoriaEmJogo(jogo.getNome(),CategoriaDeJogo.LUTA);
				} catch (JogoInexistenteException | CategoriaJaAdicionadaException e1) {
					JOptionPane.showMessageDialog(null, "Categoria ja adicionada");
					e1.printStackTrace();
				}
				break;
			case "8":
				JOptionPane.showMessageDialog(null, "Cadastro concluido.");
				continuar = false;
				break;
			}
		}while(continuar == true);
		
	}

}
