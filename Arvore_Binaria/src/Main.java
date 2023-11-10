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

        arvore.deleteNo(raiz, 17);
        arvore.preOrdem();


        // árvore AVL
        System.out.println("\n\n\n=-=-=-=-=-=-[Árvore Binária Balanceada]-=-=-=-=-=-=");
        ArvoreBalanceada arvoreBalanceada = new ArvoreBalanceada();

        arvoreBalanceada.root = arvoreBalanceada.insert(arvoreBalanceada.root, 10);
        arvoreBalanceada.root = arvoreBalanceada.insert(arvoreBalanceada.root, 20);
        arvoreBalanceada.root = arvoreBalanceada.insert(arvoreBalanceada.root, 30);
        arvoreBalanceada.root = arvoreBalanceada.insert(arvoreBalanceada.root, 40);
        arvoreBalanceada.root = arvoreBalanceada.insert(arvoreBalanceada.root, 50);
        arvoreBalanceada.root = arvoreBalanceada.insert(arvoreBalanceada.root, 25);

        arvoreBalanceada.preOrder(arvoreBalanceada.root);

    }
}