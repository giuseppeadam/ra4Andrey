public class Result {
    private final double duracaoExecucao;
    private final long modificacoes;
    private final int etapas;

    public Result(double duracaoExecucao, long modificacoes, int etapas) {
        this.duracaoExecucao = duracaoExecucao;
        this.modificacoes = modificacoes;
        this.etapas = etapas;
    }

    public double getDuracaoExecucao() {
        return duracaoExecucao;
    }

    public long getModificacoes() {
        return modificacoes;
    }

    public int getEtapas() {
        return etapas;
    }
}
