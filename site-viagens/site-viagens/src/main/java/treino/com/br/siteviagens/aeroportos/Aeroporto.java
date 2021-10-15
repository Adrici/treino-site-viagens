package treino.com.br.siteviagens.aeroportos;

import treino.com.br.siteviagens.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Aeroporto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAeroporto;

    @NotBlank
    private String nomeAeroporto;

    @ManyToOne //duvida entre oneToOne
    private Pais pais;

    @Deprecated
    public Aeroporto(){

    }

    public Aeroporto(Pais pais, String nomeAeroporto) {
        this.nomeAeroporto = nomeAeroporto;
        this.pais = pais;
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
