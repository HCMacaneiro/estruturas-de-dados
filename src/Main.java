// Projeto #3 - Resolução de Problemas Estruturados em Computação
//
// Alunos:
//  Diego Lautenschlager
//  Henrique Maçaneiro
//
// Cibersegurança, 4o período


public class Main {
    public static void main(String[] args) {

        // árvore binária simples
        System.out.println("=-=-=-=-=-=-[Árvore Binária Simples]-=-=-=-=-=-=");

        Arvore arvore = new Arvore();
        No raiz = new No(10);

        // popula
        arvore.insereOrdenado(raiz);
        arvore.insereOrdenado(new No(7));
        arvore.insereOrdenado(new No(12));
        arvore.insereOrdenado(new No(5));
        arvore.insereOrdenado(new No(10));
        arvore.insereOrdenado(new No(8));
        arvore.insereOrdenado(new No(4));
        arvore.insereOrdenado(new No(9));
        arvore.insereOrdenado(new No(8));
        arvore.insereOrdenado(new No(17));
        arvore.insereOrdenado(new No(12));
        arvore.insereOrdenado(new No(19));
        arvore.insereOrdenado(new No(20));

        arvore.verificaValor(12, 0);

        // percorre a árvore
        arvore.preOrdem();
        arvore.inOrdem();
        arvore.posOrdem();

        // remove
        arvore.removeMaior();
        arvore.preOrdem();

        arvore.removeMenor();
        arvore.preOrdem();

        arvore.removeNo(raiz, 17);
        arvore.preOrdem();


        // árvore AVL
        System.out.println("\n\n\n=-=-=-=-=-=-[Árvore Binária Balanceada]-=-=-=-=-=-=");
        ArvoreBalanceada arvoreBalanceada = new ArvoreBalanceada();

        // insere
        arvoreBalanceada.raiz = arvoreBalanceada.insere(arvoreBalanceada.raiz, 30);
        arvoreBalanceada.raiz = arvoreBalanceada.insere(arvoreBalanceada.raiz, 50);
        arvoreBalanceada.raiz = arvoreBalanceada.insere(arvoreBalanceada.raiz, 22);
        arvoreBalanceada.raiz = arvoreBalanceada.insere(arvoreBalanceada.raiz, 4);
        arvoreBalanceada.raiz = arvoreBalanceada.insere(arvoreBalanceada.raiz, 5);
        arvoreBalanceada.raiz = arvoreBalanceada.insere(arvoreBalanceada.raiz, 1);
        arvoreBalanceada.raiz = arvoreBalanceada.insere(arvoreBalanceada.raiz, 60);
        arvoreBalanceada.raiz = arvoreBalanceada.insere(arvoreBalanceada.raiz, 70);
        arvoreBalanceada.raiz = arvoreBalanceada.insere(arvoreBalanceada.raiz, 90);
        arvoreBalanceada.raiz = arvoreBalanceada.insere(arvoreBalanceada.raiz, 10);
        arvoreBalanceada.raiz = arvoreBalanceada.insere(arvoreBalanceada.raiz, 120);
        arvoreBalanceada.preOrder(arvoreBalanceada.raiz);

        // remove
        arvoreBalanceada.removeNoBalanceado(arvoreBalanceada.raiz, 30);
        System.out.println("");
        arvoreBalanceada.preOrder(arvoreBalanceada.raiz);

    }
}