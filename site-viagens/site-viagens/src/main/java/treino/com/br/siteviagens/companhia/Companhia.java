package treino.com.br.siteviagens.companhia;

import org.hibernate.annotations.CreationTimestamp;
import treino.com.br.siteviagens.pais.Pais;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Companhia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nomeCompanhia; //deve ser unico UniqueValue


    @CreationTimestamp
    private LocalDateTime instanteCriacao = LocalDateTime.now();

    @ManyToOne
    private Pais pais;

    @Deprecated
    public Companhia() {

    }
//construtor com os dados da request
    public Companhia(String nomeCompanhia,  Pais pais) {
        this.nomeCompanhia = nomeCompanhia;

        this.pais = pais;
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

    public Pais getPais() {
        return pais;
    }
}
