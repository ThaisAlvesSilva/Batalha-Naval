package CodigosFonte;

import java.awt.GridLayout;
import java.util.Random;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PreencheTabuleiro extends JFrame{
	private Botao[][] Matriz= new Botao[10][10];
	private JPanel tabuleiro = new JPanel();
	int[][] MatrizComValores;
	Tabuleiro NovoTabuleiro = new Tabuleiro(10, 10);
	Icon imagem; 
	int i, j;
	
	public PreencheTabuleiro() {
		tabuleiro.setLayout(new GridLayout(10,10));
		MatrizComValores = NovoTabuleiro.getTabuleiro();
	}
	
	public Botao[][] getMatriz(){
		return this.Matriz;
	}
	
	public JPanel CriaBotoes(Icon imagem) {
		for(i=0;i<10;i++){
			for(j=0;j<10;j++){
				this.Matriz[i][j] = new Botao();
				this.Matriz[i][j].getBotao().setIcon(imagem);
				this.Matriz[i][j].setValor((MatrizComValores[i][j]));
				tabuleiro.add(this.Matriz[i][j].getBotao());
				this.Matriz[i][j].setAberto(false);
			}
		}
		return tabuleiro;
	}
	public JPanel viraBotoes(Botao Matriz[][]){
		for(i=0;i<10;i++){
			for(j=0;j<10;j++){
				if(Matriz[i][j].getValor() == 1) {
					imagem = new ImageIcon(getClass().getResource("/Imagens/bunda-baixo.png"));
					Matriz[i][j].getBotao().setIcon(imagem);
					
				}
				if(Matriz[i][j].getValor() == 2){	
					imagem = new ImageIcon(getClass().getResource("/Imagens/bunda-cima.png"));
					Matriz[i][j].getBotao().setIcon(imagem);
					
				}
				if(Matriz[i][j].getValor() == 3) {
					imagem = new ImageIcon(getClass().getResource("/Imagens/bunda-direita.png"));
					Matriz[i][j].getBotao().setIcon(imagem);	
					
				}
				if(Matriz[i][j].getValor() == 5) {
					imagem = new ImageIcon(getClass().getResource("/Imagens/bunda-esquerda.png"));
					Matriz[i][j].getBotao().setIcon(imagem);	
				}
				if(Matriz[i][j].getValor() == 6) {
					imagem = new ImageIcon(getClass().getResource("/Imagens/cabeca-baixo.png"));
					Matriz[i][j].getBotao().setIcon(imagem);	
					
				}
				if(Matriz[i][j].getValor() == 7) {
					imagem = new ImageIcon(getClass().getResource("/Imagens/cabeca-cima.png"));
					Matriz[i][j].getBotao().setIcon(imagem);	
				
				}
				if(Matriz[i][j].getValor() == 8) {
					imagem = new ImageIcon(getClass().getResource("/Imagens/cabeca-direita.png"));
					Matriz[i][j].getBotao().setIcon(imagem);	
					
				}
				if(Matriz[i][j].getValor() == 9) {
					imagem = new ImageIcon(getClass().getResource("/Imagens/cabeca-esquerda.png"));
					Matriz[i][j].getBotao().setIcon(imagem);	
					
				}
				if(Matriz[i][j].getValor() == 10) {
					imagem = new ImageIcon(getClass().getResource("/Imagens/meio-cima-baixo.png"));
					Matriz[i][j].getBotao().setIcon(imagem);	
				}
				if(Matriz[i][j].getValor() == 11) {
					imagem = new ImageIcon(getClass().getResource("/Imagens/meio-direita-esquerda.png"));
					Matriz[i][j].getBotao().setIcon(imagem);		
				}
				if(Matriz[i][j].getValor() == 0 || Matriz[i][j].getValor() == 4) {
					imagem = new ImageIcon(getClass().getResource("/Imagens/agua_mexida.jpg"));
					Matriz[i][j].getBotao().setIcon(imagem);
				}
				
				tabuleiro.add(Matriz[i][j].getBotao());
				Matriz[i][j].setAberto(true);
			}
		}
		return tabuleiro;
	}

}
