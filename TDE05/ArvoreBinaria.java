// Alunos: Henrique Maçaneiro e Diego Lautenschlager
public class ArvoreBinaria {
    private Node raiz;

    public void insereElemento(int informacao) {
        if (raiz == null) {
            raiz = new Node(informacao);
            return;
        }
        else if(raiz.getInformacao() == informacao) {
            return;
        }
       else {
           insereElementoRecursivo(raiz, informacao);
       }
    }

    private void insereElementoRecursivo(Node atual, int informacao) {
        if(atual.getInformacao() > informacao) {
            if(atual.getEsquerda() == null) {
                atual.setEsquerda(new Node(informacao));
                return;
            }
            else if(atual.getEsquerda().getInformacao() == informacao) {
                return;
            }
            else {
                insereElementoRecursivo(atual.getEsquerda(), informacao);
            }
        }
        else if(atual.getInformacao() < informacao) {
            if(atual.getDireita() == null) {
                atual.setDireita(new Node(informacao));
            }
            else if(atual.getDireita().getInformacao() == informacao) {
                return;
            }
            else {
                insereElementoRecursivo(atual.getDireita(), informacao);
            }
        }
    }

    public void preordem() {
        preordemrecursivo(raiz);
    }

    private void preordemrecursivo(Node atual) {
        if (atual == null) {
            return;
        }
        System.out.println(atual.getInformacao());
        preordemrecursivo(atual.getEsquerda());
        preordemrecursivo(atual.getDireita());
        }
    public void inordem() {
        inordemrecursivo(raiz);
    }

    private void inordemrecursivo(Node atual) {
        if(atual == null) {
            return;
        }
        inordemrecursivo(atual.getEsquerda());
        System.out.println(atual.getInformacao());
        inordemrecursivo(atual.getDireita());
    }

    public void posordem() {
        posordemrecursivo(raiz);
    }

    private void posordemrecursivo(Node atual) {
        if(atual == null) {
            return;
        }
        posordemrecursivo(atual.getEsquerda());
        posordemrecursivo(atual.getDireita());
        System.out.println(atual.getInformacao());
    }

    public int removeMaiorElemento() {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
            return 0;
        }
        else if (raiz.getDireita() == null) {
            int maiorValor = raiz.getInformacao();
            raiz = raiz.getEsquerda();
            return maiorValor;
        }
        return removeMaiorElementoRecursivo(raiz);
    }

    private int removeMaiorElementoRecursivo(Node pai) {
        Node atual = pai.getDireita();
        if (atual.getDireita() == null) {
            int maiorValor = atual.getInformacao();
            pai.setDireita(atual.getEsquerda());
            return maiorValor;
        } else {
            return removeMaiorElementoRecursivo(atual);
        }
    }

    public int removeMenorElemento() {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
            return 0;
        }
        else if (raiz.getEsquerda() == null) {
            int menorValor = raiz.getInformacao();
            raiz = raiz.getDireita();
            return menorValor;
        }
        return removeMenorElementoRecursivo(raiz);
    }

    private int removeMenorElementoRecursivo(Node pai) {
        Node atual = pai.getEsquerda();
        if (atual.getEsquerda() == null) {
            int menorValor = atual.getInformacao();
            pai.setEsquerda(atual.getDireita());
            return menorValor;
        } else {
            return removeMenorElementoRecursivo(atual);
        }
    }

    public void removeElemento(int info) {
        raiz = removeElementoRecursivo(raiz, info);
    }

    private Node removeElementoRecursivo(Node atual, int info) {
        if (atual == null) {
            return null;
        }

        if (info < atual.getInformacao()) {
            atual.setEsquerda(removeElementoRecursivo(atual.getEsquerda(), info));
        }
        else if (info > atual.getInformacao()) {
            atual.setDireita(removeElementoRecursivo(atual.getDireita(), info));
        }
        else {
            if (atual.getEsquerda() == null) {
                return atual.getDireita();
            } else if (atual.getDireita() == null) {
                return atual.getEsquerda();
            }

            atual.setInformacao(buscaMaior(atual.getEsquerda()));

            atual.setEsquerda(removeElementoRecursivo(atual.getEsquerda(), atual.getInformacao()));
        }

        return atual;
    }

    private int buscaMaior(Node pai) {
        int maiorValor = pai.getInformacao();
        while (pai.getDireita() != null) {
            maiorValor = pai.getDireita().getInformacao();
            pai = pai.getDireita();
        }
        return maiorValor;
    }


}
