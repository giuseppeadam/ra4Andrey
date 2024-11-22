public class MergeSort {
    public static Result ordenar(int[] numeros) {
        long inicio = System.nanoTime();
        int tamanho = calcularTamanho(numeros);
        int[] temporario = new int[tamanho];
        int alteracoes = 0, etapas = 0;

        for (int largura = 1; largura < tamanho; largura *= 2) {
            int esquerda = 0;
            while (esquerda < tamanho) {
                int meio = esquerda + largura - 1;
                if (meio >= tamanho) meio = tamanho - 1;
                int direita = esquerda + 2 * largura - 1;
                if (direita >= tamanho) direita = tamanho - 1;

                etapas += juntar(numeros, temporario, esquerda, meio, direita);
                alteracoes += direita - esquerda + 1;
                esquerda += 2 * largura;
            }
        }

        long tempoExecucao = System.nanoTime() - inicio;
        return new Result((double) tempoExecucao / 1000000.0, alteracoes, etapas);
    }

    private static int juntar(int[] array, int[] tempArray, int inicio, int meio, int fim) {
        int i = inicio, j = meio + 1, k = inicio;
        int etapas = 0;

        while (i <= meio && j <= fim) {
            if (array[i] <= array[j]) {
                tempArray[k] = array[i++];
            } else {
                tempArray[k] = array[j++];
            }
            k++;
            etapas++;
        }

        while (i <= meio) tempArray[k++] = array[i++];
        while (j <= fim) tempArray[k++] = array[j++];

        for (i = inicio; i <= fim; i++) array[i] = tempArray[i];

        return etapas;
    }

    private static int calcularTamanho(int[] lista) {
        int tamanho = 0;
        while (true) {
            try {
                int ignorado = lista[tamanho];
                tamanho++;
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
        return tamanho;
    }
}
