package treino.com.br.siteviagens.rota;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Rota {

    /*
    - Não pode existir mais de uma de rota com o mesmo aeroporto de origem e mesmo
    aeroporto de destino.
     - A rota não pode ter o aeroporto de origem e destino iguais.*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeRota;

    @NotBlank
    private String aeroportoOrigem;

    @NotBlank
    private String aeroportoDestino;

    @NotNull
    @Positive
    private BigDecimal duracaoMinutosRota;

    public Rota(String nomeRota, String aeroportoOrigem, String aeroportoDestino, BigDecimal duracaoMinutosRota) {

        this.nomeRota = nomeRota;
        this.aeroportoOrigem = aeroportoOrigem;
        this.aeroportoDestino = aeroportoDestino;
        this.duracaoMinutosRota = duracaoMinutosRota;
    }

    public Rota() {
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

    public BigDecimal getDuracaoMinutosRota() {
        return duracaoMinutosRota;
    }
}
