package Steam_zuado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PesquisaPrecoDoJogoController implements ActionListener {
	private SteamPOO sistema;
	private JFrame janelaPrincipal;
	
	public PesquisaPrecoDoJogoController(SteamPOO sistema, JFrame janelaPrincipal) {
		this.sistema = sistema;
		this.janelaPrincipal = janelaPrincipal;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nome = JOptionPane.showInputDialog("Digite o nome jogo: ");
		try {
			JOptionPane.showMessageDialog(janelaPrincipal, sistema.pesquisaPrecoDoJogo(nome));
		} catch (JogoInexistenteException e1) {
			JOptionPane.showMessageDialog(janelaPrincipal, "Jogo inexistente");
			e1.printStackTrace();
		}
		
	}

}
