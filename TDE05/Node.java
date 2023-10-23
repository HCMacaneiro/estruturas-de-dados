// Alunos: Henrique Maçaneiro e Diego Lautenschlager
public class Node {
    private int info;
    private Node esquerda;
    private Node direita;

    public Node(int informacao) {
        this.info = informacao;
        this.esquerda = this.direita = null;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }

    public Node getDireita() {
        return this.direita;
    }
    public Node getEsquerda() {
        return this.esquerda;
    }


    public Integer getInformacao() { return this.info; }

    public void setInformacao(int info) { this.info = info; }

}
