package treino.com.br.siteviagens.aeroportos;

import com.sun.istack.NotNull;
import treino.com.br.siteviagens.pais.Pais;
import treino.com.br.siteviagens.utils.ExistsId;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class AeroportosRequest {
    @ExistsId(domainClass= Aeroportos.class,fieldName="id")
    private Long idAeroporto;

    @NotBlank
    private String nomeAeroporto;

    @NotBlank
    @ManyToOne
    private Pais pais;

    public AeroportosRequest(String nomeAeroporto, Pais pais) {
        this.nomeAeroporto = nomeAeroporto;
        this.pais = pais;
    }

    public String getNomeAeroporto() {
        return nomeAeroporto;
    }

    public Pais getPais() {
        return pais;
    }


    public Aeroportos toModel() {
        return new Aeroportos(pais,nomeAeroporto);
    }
}
