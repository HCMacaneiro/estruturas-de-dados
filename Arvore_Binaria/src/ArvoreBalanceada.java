public class ArvoreBalanceada {

    NoBalanceado root;

    int altura(NoBalanceado N) {
        if (N == null)
            return 0;

        return N.altura;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    NoBalanceado direitaRotate(NoBalanceado y) {
        NoBalanceado x = y.esquerda;
        NoBalanceado T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;

        // Return new root 
        return x;
    }

    NoBalanceado esquerdaRotate(NoBalanceado x) {
        NoBalanceado y = x.direita;
        NoBalanceado T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;

        // Return new root 
        return y;
    }

    int getBalance(NoBalanceado N) {
        if (N == null)
            return 0;

        return altura(N.esquerda) - altura(N.direita);
    }

    NoBalanceado insert(NoBalanceado NoBalanceado, int informacao) {

        if (NoBalanceado == null)
            return (new NoBalanceado(informacao));

        if (informacao < NoBalanceado.informacao)
            NoBalanceado.esquerda = insert(NoBalanceado.esquerda, informacao);
        else if (informacao > NoBalanceado.informacao)
            NoBalanceado.direita = insert(NoBalanceado.direita, informacao);
        else
            return NoBalanceado;

        NoBalanceado.altura = 1 + max(altura(NoBalanceado.esquerda),
                altura(NoBalanceado.direita)); 

        int balance = getBalance(NoBalanceado);


        // rotacao dupla
        if (balance > 1 && informacao < NoBalanceado.esquerda.informacao)
            return direitaRotate(NoBalanceado);

        if (balance < -1 && informacao > NoBalanceado.direita.informacao)
            return esquerdaRotate(NoBalanceado);

        if (balance > 1 && informacao > NoBalanceado.esquerda.informacao) {
            NoBalanceado.esquerda = esquerdaRotate(NoBalanceado.esquerda);
            return direitaRotate(NoBalanceado);
        }

        if (balance < -1 && informacao < NoBalanceado.direita.informacao) {
            NoBalanceado.direita = direitaRotate(NoBalanceado.direita);
            return esquerdaRotate(NoBalanceado);
        }

        return NoBalanceado;
    }

    void preOrder(NoBalanceado NoBalanceado) {
        if (NoBalanceado != null) {
            System.out.print(NoBalanceado.informacao + " ");
            preOrder(NoBalanceado.esquerda);
            preOrder(NoBalanceado.direita);
        }
    }

}