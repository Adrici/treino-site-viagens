package treino.com.br.siteviagens.companhia;

import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CompanhiaResponse {

    private Long id;
    private String nomeCompanhia; //deve ser unico UniqueValue
    private LocalDateTime instanteCriacao = LocalDateTime.now();

    public CompanhiaResponse(Companhia companhia) {
        this.id = id;
        this.nomeCompanhia = nomeCompanhia;
        this.instanteCriacao = instanteCriacao;
    }


    public Long getId() {
        return id;
    }

    public String getNomeCompanhia() {
        return nomeCompanhia;
    }

    public LocalDateTime getInstanteCriacao() {
        return instanteCriacao;
    }
}
