package CodigosFonte;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class Painel extends JPanel{
	private JButton botao_iniciar = new JButton("INICIAR");
	private JButton botao_finalizar = new JButton("FINALIZAR");
	private JButton botao_tutorial = new JButton("TUTORIAL");;
	private JButton mostrarNavios = new JButton("MOSTRAR NAVIOS");
	
	private Botao[][] Matriz = new Botao[10][10];
	PreencheTabuleiro novoTabuleiro;
	ButtonHandler handler = new ButtonHandler();
	
	private boolean iniciou = false;
	private boolean perdeu = false;
	
	private JPanel tabuleiro = new JPanel();
	private JPanel botoes = new JPanel();
	
	Sons som = new Sons();
	Icon imagemInicial= new ImageIcon(getClass().getResource("/Imagens/tela_inicial.PNG"));
	Icon imagem; 
	
	JLabel labelComImagemInicial = new JLabel();
	private JLabel titulo;
	
	private int quantidadeDeBombas;
	private int quantidadeDeNaviosAchados;
	int i,j;
	
	public Painel() {
		setLayout(new BorderLayout());
		
		titulo = new JLabel("BATALHA NAVAL");
		titulo.setFont(new Font("Tahoma",1,30));
		titulo.setForeground(new Color(200,146,76));
		titulo.setHorizontalAlignment(JLabel.CENTER);			//ALINHANDO O TEXTO NO CENTRO
		add("North",titulo);
		
		labelComImagemInicial.setIcon(imagemInicial);
		add("Center", labelComImagemInicial);
		
		botoes.add(botao_tutorial);
		botoes.add(botao_iniciar);
		botoes.add(botao_finalizar);
		add(botoes,BorderLayout.SOUTH);
		
		//ADICIONANDO EVENTO AOS BOTÕES
		botao_tutorial.addActionListener(handler);
		botao_iniciar.addActionListener(handler);
		botao_finalizar.addActionListener(handler);
		
		mostrarNavios = new JButton("MOSTRAR NAVIOS");
		
		titulo = new JLabel();
		
		titulo.setFont(new Font("Tahoma",1,15));
		titulo.setForeground(new Color(250,100,100));
		atualizaBombas(0);
		titulo.setVisible(false);
	}
	
		//TRABALHANDO COM EVENTOS NOS BOTÕES 
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(iniciou){
				if(event.getSource() != botao_iniciar && event.getSource() != botao_finalizar && event.getSource() != botao_tutorial && event.getSource() != mostrarNavios){
					if(quantidadeDeBombas > 0){	
						if(quantidadeDeNaviosAchados != 14){
							for(i=0;i<10;i++){
								for(j=0;j<10;j++){
									if(event.getSource() == (Matriz[i][j].getBotao())){
										if(!Matriz[i][j].isAberto()){
											try {
												if(Matriz[i][j].getValor() != 0 && Matriz[i][j].getValor() != 4) {
													som.playSound("som_explosão.wav");
													quantidadeDeNaviosAchados++;
												}else{
													som.playSound("som_agua.wav");
												}
											}catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
													e.printStackTrace();					//caso dê algum erro, vai entrar no catch e escrever qual foi o erro no console
											}
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
											if(quantidadeDeNaviosAchados == 14){
												JOptionPane.showMessageDialog(null,"PARABENS!!! VOCÊ VENCEU");
											}
											

											atualizaBombas(1);
											titulo.setVisible(true);
											Matriz[i][j].setAberto(true);
											
											if(quantidadeDeBombas == 0 && perdeu != true && quantidadeDeNaviosAchados != 14) {
												perdeu = true;
												JOptionPane.showMessageDialog(null, "Você perdeu!!!!");
											}
											
																						
										}else{
											JOptionPane.showMessageDialog(null, "Clique em uma posição que não esteja aberta");
										}
									}
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, "Você já encontrou todos os navios. Clique no botao de finalizar terminar essa partida");
						}
					}else{
						JOptionPane.showMessageDialog(null, "Você não tem mais bombas!! Clique em finalizar para sair dessa partida");
						perdeu = true;	
					}
				}
			}else if(event.getSource() != botao_iniciar && event.getSource() != botao_tutorial && event.getSource() != botao_finalizar && event.getSource() != mostrarNavios){
				JOptionPane.showMessageDialog(null, "Clique no botao de iniciar para começar o jogo");
			}
			if(event.getSource() == botao_iniciar){
				if(iniciou) {
					JOptionPane.showMessageDialog(null, "Clique em finalizar para terminar essa partida");
				}else{
					novoTabuleiro = new PreencheTabuleiro();
					imagem = new ImageIcon(getClass().getResource("/Imagens/agua_parada.jpg"));
					tabuleiro = novoTabuleiro.CriaBotoes(imagem);
					Matriz = novoTabuleiro.getMatriz();
					for(i=0;i<10;i++) {
						for(j=0;j<10;j++){
							Matriz[i][j].getBotao().addActionListener(handler); //adicionando evento ao botao
						}
					}
					labelComImagemInicial.setVisible(false);
					add("Center",tabuleiro);
					mostrarNavios.addActionListener(handler);
					//add(tabuleiro);
					quantidadeDeNaviosAchados = 0;
					quantidadeDeBombas = 45;
					iniciou = true;
					atualizaBombas(0);
					titulo.setVisible(true);
					perdeu = false;
				}
			}
			if(event.getSource() == botao_finalizar) {
				if(!iniciou) {
					JOptionPane.showMessageDialog(null, "Clique no botao de iniciar para começar o jogo");
				}else{
					tabuleiro.setVisible(false);
					labelComImagemInicial.setVisible(true);
					titulo.setVisible(false);
					iniciou = false;
					mostrarNavios.setVisible(false);
					perdeu = false;
				}
			}
			if(event.getSource() == botao_tutorial) {
				JOptionPane.showMessageDialog(null, "O objetivo do jogo é bombardear todos os navios." +
				"\nOs quadrados são clicaveis e escondem o que pode ser a parte de um navio ou somente água." +
				"\n Perde o adversário que utilizar todas as suas bombas e não encontrar todos os navios." +
				"\n Utilize da sua sorte e suas bombas disponíveis para tentar acertar um navio.\n\nBOA SORTE!!");
			}
			if(perdeu && quantidadeDeNaviosAchados != 14){
				titulo.setVisible(false);
				botoes.add(mostrarNavios);
				mostrarNavios.setVisible(true);
				perdeu = false;
			}
			if(event.getSource() == mostrarNavios) {
				labelComImagemInicial.setVisible(false);
				tabuleiro.setVisible(false);
				novoTabuleiro = new PreencheTabuleiro();
				tabuleiro = novoTabuleiro.viraBotoes(Matriz);
				tabuleiro.setVisible(true);
				add("Center", tabuleiro);
			}
		}
	}
	public void atualizaBombas(int opcao) {
		titulo.setVisible(false);
		if(opcao == 1) {
			titulo.setText("Quantidade de bombas: " + --quantidadeDeBombas);		
		}else {
			titulo.setText("Quantidade de bombas: " + quantidadeDeBombas);		//PRIMEIRA VEZ QUE MOSTRA A QUANTIDADE DE BOMBAS
		}
		botoes.add(titulo);
		add(botoes,BorderLayout.SOUTH);
		titulo.setVisible(true);
	}

}