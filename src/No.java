public class No {
    private int informacao;
    private  No esquerda;
    private No direita;

    public No(int informacao){
        this.informacao = informacao;
        No esquerda = null;
        No direita = null;
    }

    public int getInformacao() {
        return this.informacao;
    }

    public No getEsquerda() {
        return this.esquerda;
    }

    public No getDireita() {
        return this.direita;
    }

    public void setEsquerda(No current){
        this.esquerda = current;
    }

    public void setDireita(No current){
        this.direita = current;
    }

    public void setInformacao(int informacao){this.informacao = informacao;}
}
