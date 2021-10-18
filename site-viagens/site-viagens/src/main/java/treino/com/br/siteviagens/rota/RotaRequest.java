package treino.com.br.siteviagens.rota;

import treino.com.br.siteviagens.utils.ExistsId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class RotaRequest {


    private String nomeRota;
    @NotBlank
    private String aeroportoOrigem;
    @NotBlank
    private String aeroportoDestino;
    @NotNull
    @Positive
    private Double duracaoMinutosRota;

    @ExistsId(domainClass=  Rota.class,fieldName="idRota", message="Já existe!")
    private Long idRota;

    public RotaRequest(String nomeRota, String aeroportoOrigem, String aeroportoDestino, Double duracaoMinutosRota, Long idRota) {
        this.nomeRota = nomeRota;
        this.aeroportoOrigem = aeroportoOrigem;
        this.aeroportoDestino = aeroportoDestino;
        this.duracaoMinutosRota = duracaoMinutosRota;
        this.idRota = idRota;
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

    public Long getIdRota() {
        return idRota;
    }

    public Rota toModel() {
        return new Rota ();
    }
}
