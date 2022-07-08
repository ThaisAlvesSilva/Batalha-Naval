# Batalha-Naval

## Introdução
Este trabalho consiste na produção de uma versão simplificada do jogo
Batalha Naval, fazendo uso da linguagem Java juntamente com a biblioteca gráfica
AWT/Swing. Seu objetivo consiste em explorar os aspectos da linguagem de
programação e seus recursos gráficos e multimídias para dessa forma, conseguir
um bom desempenho do jogo.

O jogo é constituído por botões clicáveis distribuídos em uma tela no formato
de um tabuleiro 10x10, que escondem as posições de navios com tamanhos entre 2
e 5 botões distribuídos aleatoriamente sobre o tabuleiro. O jogador terá um número
limitado de bombas, as quais ele deve utilizar para tentar bombardear os navios
escondidos. O jogo termina quando o jogador bombardeia todos os barcos ou a sua
quantidade de bombas acaba.

![image](https://user-images.githubusercontent.com/72041841/178001856-ea05bbc3-1729-4994-8861-4bb0c4fa7b5c.png)


## Solução Proposta (Desenvolvimento)
As soluções encontradas para o desdobramento do trabalho proposto foram:
- Desenvolvimento do código na IDE Eclipse, usufruindo da linguagem Java de
programação;
- Jogo com interface fluida, com bastante interação com o usuário.
- Uso de sons para maior entretenimento durante cada partida;

## Execução
Para compilar o projeto é necessário que a máquina contenha o JDK configurado.
Para rodar o nosso programa é necessário baixar e extrair a pasta com os códigos fontes, as imagens e os sons utilizados no projeto. 
Em seguida, abra o prompt de comando do Windows (CMD) e utilizando o comando cd vá para a pasta em que você salvou e extraiu os arquivos. 

Utilizando o comando dir, verifique se os arquivos estão na pasta.

	Obs: para a pasta estar completa é necessário que mostre os seguintes arquivos:

		 <DIR>          .
		 <DIR>        CodigosFonte
		 <DIR>        Imagens
			      som_agua.wav
			      som_explosão.wav

Agora, vamos testar se o compilador java está disponível na pasta atual. Para isso, utilizando o javac vamos acessar o diretório com as classes:

No CMD digite: 

	javac CodigosFonte/joguinho.java 
  
Em seguida, digite:

	java CodigosFonte.joguinho
  
Pronto, o jogo está disponível para jogar. 
