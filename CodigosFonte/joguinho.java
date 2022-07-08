package CodigosFonte;

import javax.swing.JFrame;

public class joguinho {

	public static void main(String[] args) {

		Painel jogoPainel = new Painel();
		JFrame jogo = new JFrame("BatalhaNaval");
		jogo.add(jogoPainel);
		jogo.pack();
		jogo.setSize(630, 560);
		jogo.setResizable(false);
		jogo.setVisible(true);
		jogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
