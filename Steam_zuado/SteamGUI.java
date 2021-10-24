package Steam_zuado;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Agenda.AgendaGUIV3;

public class SteamGUI extends JFrame {
	
	JLabel linha1, linha2, linha3, linha4;
	
	ImageIcon game = new ImageIcon("./imagens/game.png");
	ImageIcon add = new ImageIcon("./imagens/add.png");
	ImageIcon search = new ImageIcon("./imagens/search.png");
	ImageIcon money = new ImageIcon("./imagens/money.png");
	JButton botaoAdd, botaoSearch, botaoMoney;
	
	SteamPOO sistema = new SteamPOOHash();
	
	public SteamGUI() {
		setTitle("SteamPOO");
		setSize(800, 600);
		setLocation(150,150);
		setResizable(true);
		getContentPane().setBackground(Color.DARK_GRAY);
		
		linha1 = new JLabel("STEAM POO", JLabel.CENTER);
		linha1.setForeground(Color.RED);
		linha1.setFont(new Font("Serif", Font.BOLD, 24));
		linha2 = new JLabel(game, JLabel.CENTER);
		botaoAdd = new JButton("Adicionar Jogo", add);
		botaoAdd.addActionListener(new CadastraJogoController(sistema, this));
		botaoSearch = new JButton("Pesquisa Jogo da Categoria", search);
		botaoSearch.addActionListener(new pesquisaJogosDaCategoriaController(sistema, this));
		botaoMoney = new JButton("Pesquisa Preço", money);
		botaoMoney.addActionListener(new PesquisaPrecoDoJogoController(sistema, this));
		setLayout(new GridLayout(3,2));
		add(linha1);
		add(botaoAdd);
		add(linha2);
		add(botaoSearch);
		add(new JLabel());
		add(botaoMoney);
		
	}
	
	public static void main(String [] args) {
		JFrame janela = new SteamGUI();
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
