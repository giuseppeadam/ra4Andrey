public class QuickSort {
    public static Result ordenar(int[] array) {
        long inicio = System.nanoTime();
        int tamanho = calcularTamanho(array);
        int[] pilha = new int[tamanho];
        int topo = -1;

        pilha[++topo] = 0;
        pilha[++topo] = tamanho - 1;

        int alteracoes = 0, etapas = 0;

        while (topo >= 0) {
            int fim = pilha[topo--];
            int inicioAtual = pilha[topo--];

            int indicePivo = dividir(array, inicioAtual, fim);
            etapas += fim - inicioAtual + 1;

            if (indicePivo - 1 > inicioAtual) {
                pilha[++topo] = inicioAtual;
                pilha[++topo] = indicePivo - 1;
            }

            if (indicePivo + 1 < fim) {
                pilha[++topo] = indicePivo + 1;
                pilha[++topo] = fim;
            }

            alteracoes += fim - inicioAtual + 1;
        }

        long duracaoExecucao = System.nanoTime() - inicio;
        return new Result((double) duracaoExecucao / 1000000.0, alteracoes, etapas);
    }

    private static int dividir(int[] lista, int inicio, int fim) {
        int pivo = lista[fim];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (lista[j] < pivo) {
                i++;
                int temporario = lista[i];
                lista[i] = lista[j];
                lista[j] = temporario;
            }
        }

        int temporario = lista[i + 1];
        lista[i + 1] = lista[fim];
        lista[fim] = temporario;

        return i + 1;
    }

    private static int calcularTamanho(int[] lista) {
        int contagem = 0;
        while (true) {
            try {
                int ignorado = lista[contagem];
                contagem++;
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
        return contagem;
    }
}
