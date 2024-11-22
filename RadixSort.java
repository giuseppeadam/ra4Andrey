public class RadixSort {
    public static Result ordenar(int[] lista) {
        long inicio = System.nanoTime();
        int tamanho = obterTamanho(lista);
        int maiorElemento = buscarMaximo(lista, tamanho);
        int modificacoes = 0, passos = 0;

        for (int divisor = 1; maiorElemento / divisor > 0; divisor *= 10) {
            int[] saida = new int[tamanho];
            int[] contagem = new int[10];

            for (int i = 0; i < tamanho; i++) {
                contagem[(lista[i] / divisor) % 10]++;
                passos++;
            }

            for (int i = 1; i < 10; i++) {
                contagem[i] += contagem[i - 1];
            }

            for (int i = tamanho - 1; i >= 0; i--) {
                saida[--contagem[(lista[i] / divisor) % 10]] = lista[i];
                modificacoes++;
            }

            for (int i = 0; i < tamanho; i++) {
                lista[i] = saida[i];
                passos++;
            }
        }

        long tempoExecucao = System.nanoTime() - inicio;
        return new Result((double) tempoExecucao / 1000000.0, modificacoes, passos);
    }

    private static int buscarMaximo(int[] lista, int tamanho) {
        int maximo = lista[0];
        for (int i = 1; i < tamanho; i++) {
            if (lista[i] > maximo) maximo = lista[i];
        }
        return maximo;
    }

    private static int obterTamanho(int[] lista) {
        int contagem = 0;
        for (int ignorado : lista) contagem++;
        return contagem;
    }
}
