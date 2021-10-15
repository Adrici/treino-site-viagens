package treino.com.br.siteviagens.aeroportos;

import treino.com.br.siteviagens.companhia.Companhia;
import treino.com.br.siteviagens.pais.Pais;
import treino.com.br.siteviagens.utils.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AeroportosRequest {
    @NotBlank
    @UniqueValue(domainClass = Companhia.class, fieldName = "nomeAeroporto")
    private String nomeAeroporto;

    @NotNull
    private Long idPais;

    public AeroportosRequest( String nomeAeroporto, Long idPais) {
        this.nomeAeroporto = nomeAeroporto;
        this.idPais = idPais;
    }


    public String getNomeAeroporto() {
        return nomeAeroporto;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Aeroporto toModel(Pais pais){

        return new Aeroporto(pais,nomeAeroporto);
    }


}