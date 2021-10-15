package treino.com.br.siteviagens.aeroportos;

import treino.com.br.siteviagens.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Aeroportos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAeroporto;

    @NotBlank
    private String nomeAeroporto;

    @NotBlank
    @ManyToOne //duvida entre oneToOne
    private Pais pais;

    public Aeroportos(Pais pais, String nomeAeroporto) {
    }

    public Long getIdAeroporto() {
        return idAeroporto;
    }

    public String getNomeAeroporto() {
        return nomeAeroporto;
    }

    public Pais getPais() {
        return pais;
    }


}
