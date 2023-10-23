// Alunos: Henrique Maçaneiro e Diego Lautenschlager
public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        // Teste: Inserção de elementos
        int[] elementos = {50, 30, 70, 20, 40, 60, 80};
        for (int elem : elementos) {
            arvore.insereElemento(elem);
        }

        // Teste: Percursos
        System.out.println("Percurso em pré-ordem:");
        arvore.preordem();

        System.out.println("\nPercurso em in-ordem:");
        arvore.inordem();

        System.out.println("\nPercurso em pós-ordem:");
        arvore.posordem();

        // Teste: Remoção de elementos
        System.out.println("\nRemovendo o menor elemento: " + arvore.removeMenorElemento());
        System.out.println("Percurso em in-ordem após remoção do menor:");
        arvore.inordem();

        System.out.println("\nRemovendo o maior elemento: " + arvore.removeMaiorElemento());
        System.out.println("Percurso em in-ordem após remoção do maior:");
        arvore.inordem();

        // Teste: Remoção de um elemento específico
        System.out.println("\nRemovendo o elemento 30");
        arvore.removeElemento(30);
        System.out.println("Percurso em in-ordem após remoção do elemento 30:");
        arvore.inordem();
    }
}
