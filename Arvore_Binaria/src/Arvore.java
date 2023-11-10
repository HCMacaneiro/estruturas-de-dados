import java.util.List;

public class Arvore {

    private No raiz;

    public Arvore(){
        this.raiz = null;
    }

    public void setRaiz(No raiz){
        if (isVazio()){
            this.raiz = raiz;
        }
    }

    public boolean isVazio(){
        return this.raiz == null;
    }

    public void preOrdem(){
        if (isVazio()){
            return;
        }

        System.out.println("\n\nPré-Ordem:");
        preOrdemRecursivo(this.raiz);
    }

    public void preOrdemRecursivo(No current){
        if (current == null){
            return;
        }
        System.out.println(current.getInformacao());
        preOrdemRecursivo(current.getEsquerda());
        preOrdemRecursivo(current.getDireita());
    }

    public void inOrdem(){
        if (isVazio()){
            return;
        }
        System.out.println("\n\nIn-Ordem:");
        inOrdemRecursivo(this.raiz);
    }

    public void inOrdemRecursivo(No current){
        if (current == null){
            return;
        }
        inOrdemRecursivo(current.getEsquerda());
        System.out.println(current.getInformacao());
        inOrdemRecursivo(current.getDireita());
    }

    public void posOrdem(){
        if (isVazio()){
            return;
        }
        System.out.println("\n\nPós-Ordem");
        posOrdemRecursivo(this.raiz);
    }

    public void posOrdemRecursivo(No current){
        if (current == null){
            return;
        }
        posOrdemRecursivo(current.getEsquerda());
        posOrdemRecursivo(current.getDireita());
        System.out.println(current.getInformacao());
    }

    public No descobreMaiorNo(No raizEspecificada){
        if (isVazio()){
            return new No(-1);
        }

        No current = raizEspecificada;

        while (true){
            if (current.getDireita() == null){
                return current;
            }
            else {
                current = current.getDireita();
            }
        }
    }

    public No descobreMenorNo(No raizEspecificada){
        if (isVazio()){
            return new No(-1);
        }

        No current = raizEspecificada;

        while (true){
            if (current.getEsquerda() == null){
                return current;
            }
            else {
                current = current.getEsquerda();
            }
        }
    }

    public void removeMaior(){
        No maior = descobreMaiorNo(this.raiz);

        No current = this.raiz;
        while (true){
            if (current.getDireita() == maior){
                if (current.getDireita().getEsquerda() == null){
                    current.setDireita(null);
                    return;
                }
                else {
                    current.setDireita(current.getDireita().getEsquerda());
                    return;
                }
            }
            else {
                current = current.getDireita();
            }
        }
    }

    public void removeMenor(){
        No menor = descobreMenorNo(this.raiz);

        No current = this.raiz;
        while (true){
            if (current.getEsquerda() == menor){
                current.setEsquerda(null);
                return;
            }
            else {
                current = current.getEsquerda();
            }
        }
    }

    public void insereOrdenado(No current){
        if (isVazio()){
            setRaiz(current);
            return;
        }

        No No = this.raiz;

        while (true){
            if (current.getInformacao() >= No.getInformacao()){
                if (No.getDireita() == null){
                    No.setDireita(current);
                    return;
                }
                else {
                    No = No.getDireita();
                }
            }

            else {
                if (No.getEsquerda() == null){
                    No.setEsquerda(current);
                    return;
                }
                else {
                    No = No.getEsquerda();
                }
            }
        }

    }

    // funcao utiliza 'modo' para definir qual seu retorno, dependendo do contexto que for usada
    public No verificaValor(int informacao, int modo) {
        No current = this.raiz;
        // Nó utilizado para 'removerEscolhido'
        No paiDoCurrent = this.raiz;

        while (true) {

            if (current.getInformacao() == informacao){
                System.out.println("\nValor existe...");
                if (modo == 1) {
                    return paiDoCurrent;
                }
                return current;
            }

            else if (informacao >= current.getInformacao()){
                if (current.getDireita() == null){
                    System.out.println("\nValor não existe...");
                    return null;
                }
                else {
                    if (current != this.raiz) {
                        paiDoCurrent = paiDoCurrent.getDireita();
                    }
                    current = current.getDireita();
                }
            }

            else if (informacao < current.getInformacao()) {
                if (current.getEsquerda() == null){
                    System.out.println("\nValor não existe...");
                    return null;
                }
                else {
                    if (current != this.raiz) {
                        paiDoCurrent = paiDoCurrent.getEsquerda();
                    }
                    current = current.getEsquerda();
                }
            }
        }
    }

    public void removeEscolhido(int informacao){
        // semelhante a 'verificaValor', mas aqui busca o pai
        No paiDoEscolhido = verificaValor(informacao, 1);
        No escolhido = verificaValor(informacao, 0);

        // caso seja folha
        if (escolhido.getDireita() == null && escolhido.getEsquerda() == null){
            if (escolhido.getInformacao() >= paiDoEscolhido.getInformacao()){
                paiDoEscolhido.setDireita(null);
            }
            else {
                paiDoEscolhido.setEsquerda(null);
            }
        }

        // caso só tenha filhos em uma direção
        else if (escolhido.getDireita() != null && escolhido.getEsquerda() == null){
            if (escolhido.getInformacao() >= paiDoEscolhido.getInformacao()){
                paiDoEscolhido.setDireita(descobreMenorNo(escolhido));
            }
            else {
                paiDoEscolhido.setEsquerda(descobreMaiorNo(escolhido));
            }
        }

        // caso tenha filhos dos dois lados
        else if (escolhido.getDireita() != null && escolhido.getEsquerda() != null) {
              
        }
    }

    public No deleteNo(No raiz, int key) {
        if (isVazio())
            return raiz;

        if (raiz.getInformacao() > key) {
            raiz.setEsquerda(deleteNo(raiz.getEsquerda(), key));
            return raiz;
        } else if (raiz.getInformacao() < key) {
            raiz.setDireita(deleteNo(raiz.getDireita(), key));
            return raiz;
        }
        
        // caso 1 filho esteja vazio
        if (raiz.getEsquerda() == null) {
            No temp = raiz.getDireita();
            return temp;
        } else if (raiz.getDireita() == null) {
            No temp = raiz.getEsquerda();
            return temp;
        }

        // caso haja 2 filhos
        else {
            No filhoDoEscolhido = raiz;
            No escolhido = raiz.getDireita();
            
            while (escolhido.getDireita() != null) {
                filhoDoEscolhido = escolhido;
                escolhido = escolhido.getEsquerda();
            }

            if (filhoDoEscolhido != raiz)
                filhoDoEscolhido.setEsquerda(escolhido.getDireita());
            else
                filhoDoEscolhido.setDireita(escolhido.getDireita());

            raiz.setInformacao(escolhido.getInformacao());

            return raiz;
        }
    }

}