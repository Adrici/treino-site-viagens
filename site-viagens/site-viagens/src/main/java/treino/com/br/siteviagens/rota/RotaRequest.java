package treino.com.br.siteviagens.rota;

import treino.com.br.siteviagens.utils.ExistsId;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class RotaRequest {


    private String nomeRota;
    @NotBlank

    //validador para ver se a rota A é igual a rota B
    // Pode ser if controller => validador
    private String aeroportoOrigem;
    @NotBlank
    private String aeroportoDestino;
    @NotNull
    @Positive
    private BigDecimal duracaoMinutosRota;

    public RotaRequest(String nomeRota, String aeroportoOrigem, String aeroportoDestino, BigDecimal duracaoMinutosRota) {
        this.nomeRota = nomeRota;
        this.aeroportoOrigem = aeroportoOrigem;
        this.aeroportoDestino = aeroportoDestino;
        this.duracaoMinutosRota = duracaoMinutosRota;

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

    public BigDecimal getDuracaoMinutosRota() {
        return duracaoMinutosRota;
    }


   public Rota toModel() {

       if (this.nomeRota == null || this.nomeRota.isEmpty()) {

           return new Rota(this.aeroportoOrigem + this.aeroportoDestino,
                   this.aeroportoOrigem,this.aeroportoDestino,this.duracaoMinutosRota);
       }
       return new Rota(this.nomeRota, this.aeroportoOrigem,this.aeroportoDestino,this.duracaoMinutosRota);

    }
}
