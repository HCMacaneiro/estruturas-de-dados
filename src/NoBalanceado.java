public class NoBalanceado {
    int informacao;
    int altura;
    NoBalanceado esquerda;
    NoBalanceado direita;

    NoBalanceado(int informacao) {
        this.informacao = informacao;
        this.altura = 1;
        NoBalanceado esquerda = null;
        NoBalanceado direita  = null;
    }
}
