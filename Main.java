public class Main {
    public static void main(String[] args) {
        int[][] conjuntos = {
                {1, 100, 2, 99, 3, 98, 4, 97, 5, 96, 6, 95, 7, 94, 8, 93, 9, 92, 10, 91, 11, 90, 12, 89, 13, 88, 14, 87, 15, 86, 16, 85, 17, 84, 18, 83, 19, 82, 20, 81, 21, 80, 22, 79, 23, 78, 24, 77, 25, 76},
                {1, 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52},
                {50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
        };

        int repeticoes = 3;
        int quantidadeConjuntos = calcularTamanho(conjuntos);
        Data informacoes = new Data(3, quantidadeConjuntos);

        for (int i = 0; i < quantidadeConjuntos; i++) {
            int[] conjuntoAtual = conjuntos[i];
            

            for (int r = 0; r < repeticoes; r++) {
                int[] copiaMerge = duplicarVetor(conjuntoAtual);
                int[] copiaQuick = duplicarVetor(conjuntoAtual);
                int[] copiaRadix = duplicarVetor(conjuntoAtual);

                informacoes.armazenar("Merge Sort", MergeSort.ordenar(copiaMerge), i);
                informacoes.armazenar("Quick Sort", QuickSort.ordenar(copiaQuick), i);
                informacoes.armazenar("Radix Sort", RadixSort.ordenar(copiaRadix), i);
            }
        }

        informacoes.exibirResultados(quantidadeConjuntos);
    }

    private static int[] duplicarVetor(int[] vetor) {
        int tamanho = calcularTamanho(vetor);
        int[] copia = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            copia[i] = vetor[i];
        }
        return copia;
    }

    private static int calcularTamanho(int[][] listas) {
        int tamanho = 0;
        while (true) {
            try {
                int[] ignorado = listas[tamanho];
                tamanho++;
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
        return tamanho;
    }

    private static int calcularTamanho(int[] lista) {
        int tamanho = 0;
        for (int ignorado : lista) tamanho++;
        return tamanho;
    }
}
