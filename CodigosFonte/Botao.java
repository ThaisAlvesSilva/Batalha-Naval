package CodigosFonte;

import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.JOptionPane;
import java.awt.BorderLayout;

public class Botao extends JButton{
	private boolean aberto;
	private JButton botao;
	private int valor;
	
	public Botao(){
		this.aberto = false;
		botao = new JButton();
	}
	
	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}

	public JButton getBotao() {
		return this.botao;
	}
}
