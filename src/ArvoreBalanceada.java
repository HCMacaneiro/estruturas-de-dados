public class ArvoreBalanceada {

    NoBalanceado raiz;

    int altura(NoBalanceado N) {
        if (N == null)
            return 0;

        return N.altura;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    NoBalanceado direitaRotacionar(NoBalanceado y) {
        NoBalanceado x = y.esquerda;
        NoBalanceado T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    NoBalanceado esquerdaRotacionar(NoBalanceado x) {
        NoBalanceado y = x.direita;
        NoBalanceado T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    int getBalanceado(NoBalanceado N) {
        if (N == null)
            return 0;

        return altura(N.esquerda) - altura(N.direita);
    }

    NoBalanceado insere(NoBalanceado NoBalanceado, int informacao) {

        if (NoBalanceado == null)
            return (new NoBalanceado(informacao));

        if (informacao < NoBalanceado.informacao)
            NoBalanceado.esquerda = insere(NoBalanceado.esquerda, informacao);
        else if (informacao > NoBalanceado.informacao)
            NoBalanceado.direita = insere(NoBalanceado.direita, informacao);
        else
            return NoBalanceado;

        NoBalanceado.altura = 1 + max(altura(NoBalanceado.esquerda),
                altura(NoBalanceado.direita)); 

        int balanceadoado = getBalanceado(NoBalanceado);


        // rotacao dupla
        if (balanceadoado > 1 && informacao < NoBalanceado.esquerda.informacao)
            return direitaRotacionar(NoBalanceado);

        if (balanceadoado < -1 && informacao > NoBalanceado.direita.informacao)
            return esquerdaRotacionar(NoBalanceado);

        if (balanceadoado > 1 && informacao > NoBalanceado.esquerda.informacao) {
            NoBalanceado.esquerda = esquerdaRotacionar(NoBalanceado.esquerda);
            return direitaRotacionar(NoBalanceado);
        }

        if (balanceadoado < -1 && informacao < NoBalanceado.direita.informacao) {
            NoBalanceado.direita = direitaRotacionar(NoBalanceado.direita);
            return esquerdaRotacionar(NoBalanceado);
        }

        return NoBalanceado;
    }

    void preOrder(NoBalanceado NoBalanceado) {
        if (NoBalanceado != null) {
            System.out.println(NoBalanceado.informacao + " ");
            preOrder(NoBalanceado.esquerda);
            preOrder(NoBalanceado.direita);
        }
    }

    NoBalanceado descobreMenorNoBalanceado(NoBalanceado node)
    {
        NoBalanceado current = node;
        
        while (current.esquerda != null)
            current = current.esquerda;

        return current;
    }

    NoBalanceado removeNoBalanceado(NoBalanceado raiz, int informacao)
    {
        if (raiz == null)
            return raiz;

        if (informacao < raiz.informacao)
            raiz.esquerda = removeNoBalanceado(raiz.esquerda, informacao);

        else if (informacao > raiz.informacao)
            raiz.direita = removeNoBalanceado(raiz.direita, informacao);

        else
        {

            if ((raiz.esquerda == null) || (raiz.direita == null))
            {
                NoBalanceado temp = null;
                if (temp == raiz.esquerda)
                    temp = raiz.direita;
                else
                    temp = raiz.esquerda;

                if (temp == null)
                {
                    temp = raiz;
                    raiz = null;
                }
                // caso tenha 1 filho apenas
                else 
                    raiz = temp; 
            }
            else
            {

                NoBalanceado temp = descobreMenorNoBalanceado(raiz.direita);

                raiz.informacao = temp.informacao;

                raiz.direita = removeNoBalanceado(raiz.direita, temp.informacao);
            }
        }

        if (raiz == null)
            return raiz;

        raiz.altura = max(altura(raiz.esquerda), altura(raiz.direita)) + 1;

        int balanceado = getBalanceado(raiz);

        // Dupla Esquerda 
        if (balanceado > 1 && getBalanceado(raiz.esquerda) >= 0)
            return direitaRotacionar(raiz);

        // Dupla Esquerda DIreita 
        if (balanceado > 1 && getBalanceado(raiz.esquerda) < 0)
        {
            raiz.esquerda = esquerdaRotacionar(raiz.esquerda);
            return direitaRotacionar(raiz);
        }

        // Dupla Direita Direita
        if (balanceado < -1 && getBalanceado(raiz.direita) <= 0)
            return esquerdaRotacionar(raiz);

        // Dupla Direita Esquerda
        if (balanceado < -1 && getBalanceado(raiz.direita) > 0)
        {
            raiz.direita = direitaRotacionar(raiz.direita);
            return esquerdaRotacionar(raiz);
        }

        return raiz;
    }

}