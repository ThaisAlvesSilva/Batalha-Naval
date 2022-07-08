package CodigosFonte;

import java.util.Random;

public class Navio {
    private int tamanho;
	private int linhaCabeca;
	private int colunaCabeca;
	private String orientacao;

    public Navio(int tamanho, int linhas, int colunas){
        Random aleatorio = new Random();

        this.tamanho = tamanho;
        this.linhaCabeca = (aleatorio.nextInt(linhas));
        this.colunaCabeca = (aleatorio.nextInt(colunas));
        
        switch (aleatorio.nextInt(4)) {
            case 0:
                this.orientacao = "esquerda";
                break;
            case 1:
                this.orientacao = "cima";
                break;
            case 2:
                this.orientacao = "direita";
                break;
            case 3:
                this.orientacao = "baixo";
                break;
        }
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getLinhaCabeca() {
        return this.linhaCabeca;
    }

    public void setLinhaCabeca(int linhaCabeca) {
        this.linhaCabeca = linhaCabeca;
    }

    public int getColunaCabeca() {
        return this.colunaCabeca;
    }

    public void setColunaCabeca(int colunaCabeca) {
        this.colunaCabeca = colunaCabeca;
    }

    String getOrientacao() {
        return this.orientacao;
    }

    void setOrientacao(String orientacao) {
        this.orientacao = orientacao;
    }


    @Override
    public String toString() {
        return "{" +
            " tamanho='" + getTamanho() + "'" +
            ", linhaCabeca='" + getLinhaCabeca() + "'" +
            ", colunaCabeca='" + getColunaCabeca() + "'" +
            ", orientacao='" + getOrientacao() + "'" +
            "}";
    }
    
}