package CodigosFonte;

public class Tabuleiro{
    private int tabuleiro[][];
    private int linhas;
    private int colunas; 
    private Navio tempNavio;

	public Tabuleiro(int linhas, int colunas){
        this.tempNavio = new Navio(5, linhas, colunas);
        this.linhas = linhas;
        this.colunas = colunas;
        this.tabuleiro = new int[linhas][colunas];

        //Inicializando a matriz com 0
        for(int i = 0; i < linhas; i++){
            for(int j = 0; j < colunas; j++){
                this.tabuleiro[i][j] = 0;
            }
        }
    }

    public int getLinhas() {
        return this.linhas;
    }

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

    public int getColunas() {
        return this.colunas;
    }

    public void setColunas(int colunas) {
        this.colunas = colunas;
    }

    public Navio getTempNavio() {
        return this.tempNavio;
    }

    public void setTempNavio(Navio tempNavio) {
        this.tempNavio = tempNavio;
    }

    public int[][] getTabuleiro() {
        this.posicionaNavios();

        return this.tabuleiro;
    }

    @Override
    public String toString() {
        String matrizTabuleiro = "\n";

        for(int i = 0; i < this.linhas; i++){
            for(int j = 0; j < this.colunas; j++){
                matrizTabuleiro = matrizTabuleiro.concat(Integer.toString(this.tabuleiro[i][j]));
                matrizTabuleiro = matrizTabuleiro.concat("  ");
            }
            matrizTabuleiro = matrizTabuleiro.concat("\n");
        }

        return matrizTabuleiro;
    }

    public boolean cabe(String direcao){
        boolean res = false;
        boolean condicao1 = false;
        boolean condicao2 = true;
        
        switch (direcao) {
            case "cima":

                if((this.tempNavio.getLinhaCabeca() + 1) >= this.tempNavio.getTamanho())
                    condicao1 = true;
        
                if(condicao1){

                    for(int i = this.tempNavio.getLinhaCabeca(); i >= (this.tempNavio.getLinhaCabeca() - this.getTempNavio().getTamanho() + 1); i--){
                        if(this.tabuleiro[i][this.getTempNavio().getColunaCabeca()] != 0)
                            condicao2 = false;
                    }

                }

                break;
            case "baixo":

                if((this.getLinhas() - this.tempNavio.getLinhaCabeca()) >= this.tempNavio.getTamanho())
                    condicao1 = true;
        
                if(condicao1){

                    for(int i = this.getTempNavio().getLinhaCabeca(); i <= (this.getTempNavio().getLinhaCabeca() + this.getTempNavio().getTamanho() - 1); i++){
                        if(this.tabuleiro[i][this.getTempNavio().getColunaCabeca()] != 0)
                            condicao2 = false;
                    }

                }
                
                break;
            case "esquerda":

                if((this.tempNavio.getColunaCabeca() + 1) >= this.tempNavio.getTamanho())
                    condicao1 = true;
        
                if(condicao1){

                    for(int j = this.getTempNavio().getColunaCabeca(); j >= (this.getTempNavio().getColunaCabeca() - this.getTempNavio().getTamanho() + 1); j--){
                        if(this.tabuleiro[this.getTempNavio().getLinhaCabeca()][j] != 0)
                            condicao2 = false;
                    }

                }

                break;
            case "direita":

                if((this.getColunas() - this.tempNavio.getColunaCabeca()) >= this.tempNavio.getTamanho())
                    condicao1 = true;
        
                if(condicao1){

                    for(int j = this.getTempNavio().getColunaCabeca(); j <= (this.getTempNavio().getColunaCabeca() + this.getTempNavio().getTamanho() - 1); j++){
                        if(this.tabuleiro[this.getTempNavio().getLinhaCabeca()][j] != 0)
                            condicao2 = false;
                    }

                }

                break;
            default:
                System.out.println("Entrou nesse default mlk");
                break;
        }

        if(condicao1 == true && condicao2 == true)
            res = true;

        return res;
    }

    public int[][] adicionaNavio(int[][] tabuleiro){
        int[][] novoTabuleiro = tabuleiro; 

        switch (this.getTempNavio().getOrientacao()) {
            case "cima":

                for(int i = this.getTempNavio().getLinhaCabeca(); i >= (this.getTempNavio().getLinhaCabeca() - this.getTempNavio().getTamanho() + 1); i--){
                    if(novoTabuleiro[i][this.getTempNavio().getColunaCabeca()] == 0){
                        
                        if(i == this.getTempNavio().getLinhaCabeca()){
                            novoTabuleiro[i][this.getTempNavio().getColunaCabeca()] = 2;
                        }else if(i == (this.getTempNavio().getLinhaCabeca() - this.getTempNavio().getTamanho() + 1)){
                            novoTabuleiro[i][this.getTempNavio().getColunaCabeca()] = 7;
                        }else{
                            novoTabuleiro[i][this.getTempNavio().getColunaCabeca()] = 10;
                        }

                    }else{
                        novoTabuleiro = tabuleiro;
                        break;
                    }
                }

                break;
            case "baixo":
                
                for(int i = this.getTempNavio().getLinhaCabeca(); i <= (this.getTempNavio().getLinhaCabeca() + this.getTempNavio().getTamanho() - 1); i++){

                    if(novoTabuleiro[i][this.getTempNavio().getColunaCabeca()] == 0){

                        if(i == this.getTempNavio().getLinhaCabeca()){
                            novoTabuleiro[i][this.getTempNavio().getColunaCabeca()] = 1;
                        }else if(i == (this.getTempNavio().getLinhaCabeca() + this.getTempNavio().getTamanho() - 1)){
                            novoTabuleiro[i][this.getTempNavio().getColunaCabeca()] = 6;
                        }else{
                            novoTabuleiro[i][this.getTempNavio().getColunaCabeca()] = 10;
                        }

                    }else{
                        novoTabuleiro = tabuleiro;
                        break;
                    }

                }

                break;
            case "direita":
                
                for(int j = this.getTempNavio().getColunaCabeca(); j <= (this.getTempNavio().getColunaCabeca() + this.getTempNavio().getTamanho() - 1); j++){

                    if(novoTabuleiro[this.getTempNavio().getLinhaCabeca()][j] == 0){

                        if(j == this.getTempNavio().getColunaCabeca()){
                            novoTabuleiro[this.getTempNavio().getLinhaCabeca()][j] = 3;
                        }else if(j == (this.getTempNavio().getColunaCabeca() + this.getTempNavio().getTamanho() - 1)){
                            novoTabuleiro[this.getTempNavio().getLinhaCabeca()][j] = 8;
                        }else{
                            novoTabuleiro[this.getTempNavio().getLinhaCabeca()][j] = 11;
                        }

                    }else{
                        novoTabuleiro = tabuleiro;
                        break;
                    }

                }

                break;
            case "esquerda":
                
                for(int j = this.getTempNavio().getColunaCabeca(); j >= (this.getTempNavio().getColunaCabeca() - this.getTempNavio().getTamanho() + 1); j--){

                    if(novoTabuleiro[this.getTempNavio().getLinhaCabeca()][j] == 0){

                        if(j == this.getTempNavio().getColunaCabeca()){
                            novoTabuleiro[this.getTempNavio().getLinhaCabeca()][j] = 5;
                        }else if(j == (this.getTempNavio().getColunaCabeca() - this.getTempNavio().getTamanho() + 1)){
                            novoTabuleiro[this.getTempNavio().getLinhaCabeca()][j] = 9;
                        }else{
                            novoTabuleiro[this.getTempNavio().getLinhaCabeca()][j] = 11;
                        }

                    }else{
                        novoTabuleiro = tabuleiro;
                        break;
                    }

                }

                break;
            default:
                System.out.println("Entrou aqui mermao");
                break;
        }

        return novoTabuleiro;
    }

    public void posicionaNavios(){

        int navios = 0;
        int novoTamanho;

        while(navios < 4){

            if(this.cabe(this.getTempNavio().getOrientacao())){
                this.tabuleiro = this.adicionaNavio(this.tabuleiro);
                this.anulaAoRedor(this.getTempNavio());
                navios++;
                novoTamanho = this.getTempNavio().getTamanho() - 1;

                this.setTempNavio(new Navio(novoTamanho, this.linhas, this.colunas));                
            }else{
                this.setTempNavio(new Navio(this.getTempNavio().getTamanho(), this.linhas, this.colunas));
            }

        }

    }

    public void anulaAoRedor(Navio navio){
        switch (navio.getOrientacao()){
            case "cima":
                
                if((navio.getLinhaCabeca() - navio.getTamanho()) == -1){
                    if(navio.getColunaCabeca() == (this.colunas - 1)){ //1
                    
                        this.tabuleiro[(navio.getLinhaCabeca() + 1)][navio.getColunaCabeca()] = 4;
                        this.tabuleiro[(navio.getLinhaCabeca() + 1)][(navio.getColunaCabeca() - 1)] = 4;
                        this.tabuleiro[navio.getLinhaCabeca()][(navio.getColunaCabeca() - 1)] = 4;

                        for(int i = (navio.getLinhaCabeca() - 1); i >= 0; i--){
                            this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                        }
                    
                    }else if(navio.getColunaCabeca() > 0 && navio.getColunaCabeca() < (this.colunas - 1)){ //2
                    
                        this.tabuleiro[(navio.getLinhaCabeca() + 1)][navio.getColunaCabeca()] = 4;
                        this.tabuleiro[(navio.getLinhaCabeca() + 1)][(navio.getColunaCabeca() + 1)] = 4;
                        this.tabuleiro[navio.getLinhaCabeca()][(navio.getColunaCabeca() + 1)] = 4;
                        this.tabuleiro[(navio.getLinhaCabeca() + 1)][(navio.getColunaCabeca() - 1)] = 4;
                        this.tabuleiro[navio.getLinhaCabeca()][(navio.getColunaCabeca() - 1)] = 4;

                        for(int i = (navio.getLinhaCabeca() - 1); i >= 0; i--){
                            this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                            this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                        }

                    }else if(navio.getColunaCabeca() == 0){ //3
                        
                        this.tabuleiro[(navio.getLinhaCabeca() + 1)][(navio.getColunaCabeca() + 1)] = 4;
                        this.tabuleiro[navio.getLinhaCabeca()][(navio.getColunaCabeca() + 1)] = 4;
                        this.tabuleiro[(navio.getLinhaCabeca() + 1)][(navio.getColunaCabeca())] = 4;

                        for(int i = (navio.getLinhaCabeca() - 1); i >= 0; i--){
                            this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                        }

                    }
                }else if(navio.getLinhaCabeca() == (this.linhas - 1)){

                    if(navio.getColunaCabeca() == 0){ // 4

                        for(int i = navio.getLinhaCabeca(); i >= (this.linhas - navio.getTamanho()); i--){
                            
                            if(i == (this.linhas - navio.getTamanho())){
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i-1][navio.getColunaCabeca()] = 4;
                                this.tabuleiro[i-1][navio.getColunaCabeca() + 1] = 4;
                            }else{
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                            }

                        }

                    }else if(navio.getColunaCabeca() > 0 && navio.getColunaCabeca() < (this.colunas - 1)){ //5

                        for(int i = navio.getLinhaCabeca(); i >= (this.linhas - navio.getTamanho()); i--){
                            
                            if(i == (this.linhas - navio.getTamanho())){
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i-1][navio.getColunaCabeca()] = 4;
                                this.tabuleiro[i-1][navio.getColunaCabeca() + 1] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i-1][(navio.getColunaCabeca() - 1)] = 4;
                            }else{
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                            }

                        }

                    }else if(navio.getColunaCabeca() == (this.colunas -1)){

                        for(int i = navio.getLinhaCabeca(); i >= (this.linhas - navio.getTamanho()); i--){
                            
                            if(i == (this.linhas - navio.getTamanho())){
                                this.tabuleiro[i-1][navio.getColunaCabeca()] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i-1][(navio.getColunaCabeca() - 1)] = 4;
                            }else{
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                            }

                        }

                    }

                }else{

                    if(navio.getColunaCabeca() == 0){

                        for(int i = navio.getLinhaCabeca(); i >= ((navio.getLinhaCabeca() - navio.getTamanho()) + 1); i--){
                            
                            if(i == navio.getLinhaCabeca()){
                                this.tabuleiro[i][( navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i + 1][navio.getColunaCabeca()] = 4;
                                this.tabuleiro[i + 1][(navio.getColunaCabeca() + 1)] = 4;
                            }else if(i == ((navio.getLinhaCabeca() - navio.getTamanho()) + 1)){
                                this.tabuleiro[i - 1][navio.getColunaCabeca()] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i -1][(navio.getColunaCabeca() + 1)] = 4;
                            }else{
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                            }

                        }

                    }else if(navio.getColunaCabeca() == (this.colunas - 1)){

                        for(int i = navio.getLinhaCabeca(); i >= ((navio.getLinhaCabeca() - navio.getTamanho()) + 1); i--){
                            
                            if(i == navio.getLinhaCabeca()){
                                this.tabuleiro[i + 1][navio.getColunaCabeca()] = 4;
                                this.tabuleiro[i + 1][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;                               
                            }else if(i == ((navio.getLinhaCabeca() - navio.getTamanho()) + 1)){
                                this.tabuleiro[i - 1][navio.getColunaCabeca()] = 4;
                                this.tabuleiro[i - 1][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                            }else{
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                            }
                        
                        }

                    }else{

                        for(int i = navio.getLinhaCabeca(); i >= ((navio.getLinhaCabeca() - navio.getTamanho()) + 1); i--){
                            
                            if(i == navio.getLinhaCabeca()){
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i + 1][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i + 1][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i + 1][navio.getColunaCabeca()] = 4;
                            }else if(i == ((navio.getLinhaCabeca() - navio.getTamanho()) + 1)){
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i - 1][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i - 1][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i - 1][navio.getColunaCabeca()] = 4;
                            }else{
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                            }
                        
                        }

                    }

                }

                break;
            case "baixo":
                
                if(navio.getColunaCabeca() == 0){

                    if(navio.getLinhaCabeca() == 0){ //1

                        for(int i = navio.getLinhaCabeca(); i <= (navio.getLinhaCabeca() + navio.getTamanho() - 1); i++){
                            
                            if(i == navio.getLinhaCabeca()){
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                            }else if(i == (navio.getLinhaCabeca() + navio.getTamanho() - 1)){
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i + 1][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i + 1][navio.getColunaCabeca()] = 4;
                            }else{
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                            }

                        }

                    }else if(navio.getLinhaCabeca() == (this.linhas - navio.getTamanho())){ //9

                        for(int i = navio.getLinhaCabeca(); i <= (navio.getLinhaCabeca() + navio.getTamanho() - 1); i++){
                        
                            if(i == navio.getLinhaCabeca()){
                                tabuleiro[i - 1][(navio.getColunaCabeca())] = 4;
                                tabuleiro[i - 1][(navio.getColunaCabeca() + 1)] = 4;
                                tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                            }else if(i == (navio.getLinhaCabeca() + navio.getTamanho() - 1)){
                                tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                            }else{
                                tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                            }
    
                        }

                    }else{ //5

                        for(int i = navio.getLinhaCabeca(); i <= (navio.getLinhaCabeca() + navio.getTamanho() - 1); i++){
                        
                            if(i == navio.getLinhaCabeca()){
                                this.tabuleiro[i - 1][(navio.getColunaCabeca())] = 4;
                                this.tabuleiro[i - 1][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                            }else if(i == (navio.getLinhaCabeca() + navio.getTamanho() - 1)){
                                this.tabuleiro[i + 1][(navio.getColunaCabeca())] = 4;
                                this.tabuleiro[i + 1][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                            }else{
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                            }
    
                        }

                    }

                }else if(navio.getColunaCabeca() == (this.colunas - 1)){
                    
                    if(navio.getLinhaCabeca() == 0){ //3

                        for(int i = navio.getLinhaCabeca(); i <= (navio.getLinhaCabeca() + navio.getTamanho() - 1); i++){
                        
                            if(i == navio.getLinhaCabeca()){
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                            }else if(i == (navio.getLinhaCabeca() + navio.getTamanho() - 1)){
                                this.tabuleiro[i + 1][(navio.getColunaCabeca())] = 4;
                                this.tabuleiro[i + 1][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                            }else{
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                            }
    
                        }

                    }else if(navio.getLinhaCabeca() == (this.linhas - navio.getTamanho())){ //8

                        for(int i = navio.getLinhaCabeca(); i <= (navio.getLinhaCabeca() + navio.getTamanho() - 1); i++){
                        
                            if(i == navio.getLinhaCabeca()){
                                this.tabuleiro[i - 1][(navio.getColunaCabeca())] = 4;
                                this.tabuleiro[i - 1][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                            }else if(i == (navio.getLinhaCabeca() + navio.getTamanho() - 1)){
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                            }else{
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                            }
    
                        }

                    }else{ //7

                        for(int i = navio.getLinhaCabeca(); i <= (navio.getLinhaCabeca() + navio.getTamanho() - 1); i++){
                        
                            if(i == navio.getLinhaCabeca()){
                                this.tabuleiro[i - 1][(navio.getColunaCabeca())] = 4;
                                this.tabuleiro[i - 1][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                            }else if(i == (navio.getLinhaCabeca() + navio.getTamanho() - 1)){
                                this.tabuleiro[i + 1][(navio.getColunaCabeca())] = 4;
                                this.tabuleiro[i + 1][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                            }else{
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                            }
    
                        }

                    }

                }else{

                    if(navio.getLinhaCabeca() == 0){ //2

                        for(int i = navio.getLinhaCabeca(); i <= (navio.getLinhaCabeca() + navio.getTamanho() - 1); i++){
                        
                            if(i == navio.getLinhaCabeca()){
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                            }else if(i == (navio.getLinhaCabeca() + navio.getTamanho() - 1)){
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i + 1][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i + 1][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i + 1][(navio.getColunaCabeca())] = 4;
                            }else{
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                            }
    
                        }

                    }else if(navio.getLinhaCabeca() == (this.linhas - navio.getTamanho())){ //6

                        for(int i = navio.getLinhaCabeca(); i <= (navio.getLinhaCabeca() + navio.getTamanho() - 1); i++){
                        
                            if(i == navio.getLinhaCabeca()){
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i - 1][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i - 1][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i - 1][(navio.getColunaCabeca())] = 4;
                            }else if(i == (navio.getLinhaCabeca() + navio.getTamanho() - 1)){
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                            }else{
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                            }
    
                        }

                    }else{ //4

                        for(int i = navio.getLinhaCabeca(); i <= (navio.getLinhaCabeca() + navio.getTamanho() - 1); i++){
                        
                            if(i == navio.getLinhaCabeca()){
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i - 1][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i - 1][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i - 1][(navio.getColunaCabeca())] = 4;
                            }else if(i == (navio.getLinhaCabeca() + navio.getTamanho() - 1)){
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i + 1][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i + 1][(navio.getColunaCabeca() + 1)] = 4;
                                this.tabuleiro[i + 1][(navio.getColunaCabeca())] = 4;
                            }else{
                                this.tabuleiro[i][(navio.getColunaCabeca() - 1)] = 4;
                                this.tabuleiro[i][(navio.getColunaCabeca() + 1)] = 4;
                            }
    
                        }

                    }

                }

                break;
            case "direita":
                
                if(navio.getLinhaCabeca() == 0){

                    if(navio.getColunaCabeca() == 0){ //1

                        for(int j = navio.getColunaCabeca(); j <= (navio.getColunaCabeca() + navio.getTamanho() - 1); j++){

                            if(j == navio.getColunaCabeca()){
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }else if(j == (navio.getColunaCabeca() + navio.getTamanho() - 1)){
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j + 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j + 1] = 4;
                            }else{
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }

                        }

                    }else if(navio.getColunaCabeca() == (this.colunas - navio.getTamanho())){ //3

                        for(int j = navio.getColunaCabeca(); j <= (navio.getColunaCabeca() + navio.getTamanho() - 1); j++){

                            if(j == navio.getColunaCabeca()){
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j - 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j - 1] = 4;
                            }else if(j == (navio.getColunaCabeca() + navio.getTamanho() - 1)){
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }else{
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }
    
                        }

                    }else{ //2

                        for(int j = navio.getColunaCabeca(); j <= (navio.getColunaCabeca() + navio.getTamanho() - 1); j++){
						
                            if(j == navio.getColunaCabeca()){
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j - 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j - 1] = 4;
                            }else if(j == (navio.getColunaCabeca() + navio.getTamanho() - 1)){
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j + 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j + 1] = 4;
                            }else{
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }
    
                        }

                    }

                }else if(navio.getLinhaCabeca() == (this.linhas - 1)){

                    if(navio.getColunaCabeca() == 0){ //7

                        for(int j = navio.getColunaCabeca(); j <= (navio.getColunaCabeca() + navio.getTamanho() - 1); j++){
						
                            if(j == navio.getColunaCabeca()){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                            }else if(j == (navio.getColunaCabeca() + navio.getTamanho() - 1)){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j + 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j + 1] = 4;
                            }else{
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                            }
    
                        }

                    }else if(navio.getColunaCabeca() == (this.colunas - navio.getTamanho())){ //9

                        for(int j = navio.getColunaCabeca(); j <= (navio.getColunaCabeca() + navio.getTamanho() - 1); j++){
						
                            if(j == navio.getColunaCabeca()){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j - 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j - 1] = 4;
                            }else if(j == (navio.getColunaCabeca() + navio.getTamanho() - 1)){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                            }else{
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                            }
    
                        }

                    }else{ //8

                        for(int j = navio.getColunaCabeca(); j <= (navio.getColunaCabeca() + navio.getTamanho() - 1); j++){
						
                            if(j == navio.getColunaCabeca()){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j - 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j - 1] = 4;
                            }else if(j == (navio.getColunaCabeca() + navio.getTamanho() - 1)){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j + 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j + 1] = 4;
                            }else{
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                            }
    
                        }

                    }

                }else{

                    if(navio.getColunaCabeca() == 0){ //4

                        for(int j = navio.getColunaCabeca(); j <= (navio.getColunaCabeca() + navio.getTamanho() - 1); j++){
						
                            if(j == navio.getColunaCabeca()){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }else if(j == (navio.getColunaCabeca() + navio.getTamanho() - 1)){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j + 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j + 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j + 1] = 4;
                            }else{
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }
    
                        }

                    }else if(navio.getColunaCabeca() == (this.colunas - navio.getTamanho())){ //6

                        for(int j = navio.getColunaCabeca(); j <= (navio.getColunaCabeca() + navio.getTamanho() - 1); j++){
						
                            if(j == navio.getColunaCabeca()){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j - 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j - 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j - 1] = 4;
                            }else if(j == (navio.getColunaCabeca() + navio.getTamanho() - 1)){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }else{
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }
    
                        }

                    }else{ //5

                        for(int j = navio.getColunaCabeca(); j <= (navio.getColunaCabeca() + navio.getTamanho() - 1); j++){
						
                            if(j == navio.getColunaCabeca()){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j - 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j - 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j - 1] = 4;
                            }else if(j == (navio.getColunaCabeca() + navio.getTamanho() - 1)){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j + 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j + 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j + 1] = 4;    
                            }else{
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }
    
                        }

                    } 

                }

                break;
            case "esquerda":
                
                if(navio.getLinhaCabeca() == 0){

                    if(navio.getColunaCabeca() == (navio.getTamanho() - 1)){ //1

                        for(int j = navio.getColunaCabeca(); j >= (navio.getColunaCabeca() - navio.getTamanho() + 1); j--){

                            if(j == navio.getColunaCabeca()){
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j + 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j + 1] = 4;
                            }else if(j == (navio.getColunaCabeca() - navio.getTamanho() + 1)){
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }else{
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }
    
                        }

                    }else if(navio.getColunaCabeca() == (this.colunas - 1)){ //3

                        for(int j = navio.getColunaCabeca(); j >= (navio.getColunaCabeca() - navio.getTamanho() + 1); j--){

                            if(j == navio.getColunaCabeca()){
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }else if(j == (navio.getColunaCabeca() - navio.getTamanho() + 1)){
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j - 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j - 1] = 4;
                            }else{
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }
    
                        }

                    }else{ //2

                        for(int j = navio.getColunaCabeca(); j >= (navio.getColunaCabeca() - navio.getTamanho() + 1); j--){

                            if(j == navio.getColunaCabeca()){
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j + 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j + 1] = 4;
                            }else if(j == (navio.getColunaCabeca() - navio.getTamanho() + 1)){
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j - 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j - 1] = 4;
                            }else{
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }
    
                        }

                    }

                }else if(navio.getLinhaCabeca() == (this.linhas - 1)){

                    if(navio.getColunaCabeca() == (navio.getTamanho() - 1)){ //7

                        for(int j = navio.getColunaCabeca(); j >= (navio.getColunaCabeca() - navio.getTamanho() + 1); j--){

                            if(j == navio.getColunaCabeca()){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j + 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j + 1] = 4;
                            }else if(j == (navio.getColunaCabeca() - navio.getTamanho() + 1)){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                            }else{
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                            }
    
                        }

                    }else if(navio.getColunaCabeca() == (this.colunas - 1)){ //9

                        for(int j = navio.getColunaCabeca(); j >= (navio.getColunaCabeca() - navio.getTamanho() + 1); j--){

                            if(j == navio.getColunaCabeca()){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                            }else if(j == (navio.getColunaCabeca() - navio.getTamanho() + 1)){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j - 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j - 1] = 4;
                            }else{
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                            }
    
                        }

                    }else{ //8

                        for(int j = navio.getColunaCabeca(); j >= (navio.getColunaCabeca() - navio.getTamanho() + 1); j--){

                            if(j == navio.getColunaCabeca()){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j + 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j + 1] = 4;
                            }else if(j == (navio.getColunaCabeca() - navio.getTamanho() + 1)){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j - 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j - 1] = 4;
                            }else{
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                            }
    
                        }

                    }

                }else{

                    if(navio.getColunaCabeca() == (navio.getTamanho() - 1)){ //6

                        for(int j = navio.getColunaCabeca(); j >= (navio.getColunaCabeca() - navio.getTamanho() + 1); j--){

                            if(j == navio.getColunaCabeca()){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j + 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j + 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j + 1] = 4;
                            }else if(j == (navio.getColunaCabeca() - navio.getTamanho() + 1)){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }else{
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }
    
                        }

                    }else if(navio.getColunaCabeca() == (this.colunas - 1)){ //4

                        for(int j = navio.getColunaCabeca(); j >= (navio.getColunaCabeca() - navio.getTamanho() + 1); j--){

                            if(j == navio.getColunaCabeca()){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }else if(j == (navio.getColunaCabeca() - navio.getTamanho() + 1)){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j - 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j - 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j - 1] = 4;
                            }else{
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }
    
                        }

                    }else{ //5

                        for(int j = navio.getColunaCabeca(); j >= (navio.getColunaCabeca() - navio.getTamanho() + 1); j--){

                            if(j == navio.getColunaCabeca()){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j + 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j + 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j + 1] = 4;
                            }else if(j == (navio.getColunaCabeca() - navio.getTamanho() + 1)){
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca())][j - 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j - 1] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j - 1] = 4;
                            }else{
                                this.tabuleiro[(navio.getLinhaCabeca() - 1)][j] = 4;
                                this.tabuleiro[(navio.getLinhaCabeca() + 1)][j] = 4;
                            }
    
                        }

                    }

                }

                break;
            default:
                System.out.println("Entrou num default aqui slc");
                break;
        }
    }
}