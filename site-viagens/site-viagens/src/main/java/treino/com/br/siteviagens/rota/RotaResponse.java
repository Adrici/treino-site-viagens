package treino.com.br.siteviagens.rota;

public class RotaResponse {

    private Long id;
    private String nomeRota;
    private String aeroportoOrigem;
    private String aeroportoDestino;
    private Double duracaoMinutosRota;


    public RotaResponse(Rota rota) {
        this.id = rota.getId();
        this.nomeRota = rota.getNomeRota();
        this.aeroportoOrigem = rota.getAeroportoOrigem();
        this.aeroportoDestino = rota.getAeroportoDestino();
        this.duracaoMinutosRota = rota.getDuracaoMinutosRota();
    }

    public Long getId() {
        return id;
    }

    public String getNomeRota() {
        return nomeRota;
    }

    public String getAeroportoOrigem() {
        return aeroportoOrigem;
    }

    public String getAeroportoDestino() {
        return aeroportoDestino;
    }

    public Double getDuracaoMinutosRota() {
        return duracaoMinutosRota;
    }
}
