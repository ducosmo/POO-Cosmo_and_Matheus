package Steam_zuado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class pesquisaJogosDaCategoriaController implements ActionListener{
	private SteamPOO sistema;
	private JFrame janelaPrincipal;
	
	
	public pesquisaJogosDaCategoriaController(SteamPOO sistema, JFrame janelaPrincipal) {
		this.sistema = sistema;
		this.janelaPrincipal = janelaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		SteamPOO sistema = new SteamPOOHash();
		boolean cont = false;
		do {
			String categoria = JOptionPane.showInputDialog(janelaPrincipal,"~Escolha as categorias para o jogo digitando o numero correspondente~ \n"
					+ "1-AVENTURA\n"
					+ "2-TERROR\n"
					+ "3-ARCADE\n"
					+ "4-GUERRA\n"
					+ "5-CORRIDA\n"
					+ "6-AÇÃO\n"
					+ "7-LUTA\n");
			switch(categoria) {
			case "1":
				JOptionPane.showMessageDialog(null ,sistema.pesquisaJogosDaCategoria(CategoriaDeJogo.AVENTURA));
				cont=true;
				break;
			case "2":
				JOptionPane.showMessageDialog(null ,sistema.pesquisaJogosDaCategoria(CategoriaDeJogo.TERROR));
				cont=true;
				break;
			case "3":
				JOptionPane.showMessageDialog(null ,sistema.pesquisaJogosDaCategoria(CategoriaDeJogo.ARCADE));
				cont=true;
				break;
			case "4":
				JOptionPane.showMessageDialog(null ,sistema.pesquisaJogosDaCategoria(CategoriaDeJogo.GUERRA));
				cont=true;
				break;
			case "5":
				JOptionPane.showMessageDialog(null ,sistema.pesquisaJogosDaCategoria(CategoriaDeJogo.CORRIDA));
				cont=true;
				break;
			case "6":
				JOptionPane.showMessageDialog(null ,sistema.pesquisaJogosDaCategoria(CategoriaDeJogo.ACAO));
				cont=true;
				break;
			case "7":
				JOptionPane.showMessageDialog(null ,sistema.pesquisaJogosDaCategoria(CategoriaDeJogo.LUTA));
				cont=true;
				break;
			default:
	            JOptionPane.showMessageDialog(null, "Opção inválida!");
			}
		}while(cont==false);
	}

}
