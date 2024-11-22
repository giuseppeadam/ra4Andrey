public class Data {
    private final String[] metodos;
    private final double[][] tempos;
    private final int[][] passos;
    private final long[][] alteracoes;
    private int totalDeMetodos = 0;

    public Data(int capacidadeMetodos, int conjuntos) {
        metodos = new String[capacidadeMetodos];
        tempos = new double[capacidadeMetodos][conjuntos];
        passos = new int[capacidadeMetodos][conjuntos];
        alteracoes = new long[capacidadeMetodos][conjuntos];
    }

    public void armazenar(String metodo, Result resultado, int indiceConjunto) {
        int indice = -1;
        for (int i = 0; i < totalDeMetodos; i++) {
            if (verificarIgualdade(metodos[i], metodo)) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            metodos[totalDeMetodos] = metodo;
            indice = totalDeMetodos;
            totalDeMetodos++;
        }

        tempos[indice][indiceConjunto] += resultado.getDuracaoExecucao(); // Corrigido aqui
        passos[indice][indiceConjunto] += resultado.getEtapas();          // Corrigido aqui
        alteracoes[indice][indiceConjunto] += resultado.getModificacoes(); // Corrigido aqui
    }

    public void exibirResultados(int conjuntos) {
        for (int i = 0; i < totalDeMetodos; i++) {
            boolean metodoValido = false;
            for (int j = 0; j < conjuntos; j++) {
                if (tempos[i][j] > 0 || passos[i][j] > 0 || alteracoes[i][j] > 0) {
                    metodoValido = true;
                    break;
                }
            }
            if (!metodoValido) continue;

            imprimirLinha(metodos[i] + ":");
            for (int j = 0; j < conjuntos; j++) {
                if (tempos[i][j] > 0 || passos[i][j] > 0 || alteracoes[i][j] > 0) {
                    imprimirLinha("Conjunto " + (j + 1) + " -> Tempo: " +
                            tempos[i][j] + "  Passos: " +
                            passos[i][j] + " / Alterações: " +
                            alteracoes[i][j]);
                }
            }
        }
    }

    private boolean verificarIgualdade(String textoA, String textoB) {
        if (textoA == null || textoB == null) return false;
        int comprimentoA = contarCaracteres(textoA);
        int comprimentoB = contarCaracteres(textoB);
        if (comprimentoA != comprimentoB) return false;
        for (int i = 0; i < comprimentoA; i++) {
            if (textoA.charAt(i) != textoB.charAt(i)) return false;
        }
        return true;
    }

    private int contarCaracteres(String texto) {
        int contagem = 0;
        for (char ignorado : texto.toCharArray()) contagem++;
        return contagem;
    }

    private void imprimirLinha(String mensagem) {
        for (int i = 0; i < contarCaracteres(mensagem); i++) {
            System.out.print(mensagem.charAt(i));
        }
        System.out.print("\n");
    }
}
