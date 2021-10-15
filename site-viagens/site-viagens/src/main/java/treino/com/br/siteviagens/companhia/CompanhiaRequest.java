package treino.com.br.siteviagens.companhia;

import org.hibernate.annotations.CreationTimestamp;
import treino.com.br.siteviagens.pais.Pais;
import treino.com.br.siteviagens.utils.UniqueValue;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CompanhiaRequest {

    @NotBlank
    @UniqueValue(domainClass = Companhia.class, fieldName = "nomeCompanhia")
    private String nomeCompanhia; //deve ser unico UniqueValue

    @NotNull
    @CreationTimestamp
    private LocalDateTime instanteCriacao = LocalDateTime.now();

    @NotBlank
    @ManyToOne
    private Pais pais;


    public CompanhiaRequest(String nomeCompanhia, LocalDateTime instanteCriacao, Pais pais) {
        this.nomeCompanhia = nomeCompanhia;
        this.instanteCriacao = instanteCriacao;
        this.pais = pais;
    }

    public String getNomeCompanhia() {
        return nomeCompanhia;
    }

    public LocalDateTime getInstanteCriacao() {
        return instanteCriacao;
    }

    public Pais getPais() {
        return pais;
    }

    public Companhia toModel() {
        return new Companhia(this.nomeCompanhia);
    }
}
