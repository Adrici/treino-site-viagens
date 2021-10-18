package treino.com.br.siteviagens.companhia;

import treino.com.br.siteviagens.pais.Pais;
import treino.com.br.siteviagens.utils.UniqueValue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//quando criamos o a request temos que passar os dados que vamos preencher
public class CompanhiaRequest {

    @NotBlank
    @UniqueValue(domainClass = Companhia.class, fieldName = "nomeCompanhia")
    private String nomeCompanhia;

    @NotNull
    private Long idPais;


    public CompanhiaRequest(String nomeCompanhia, Long idPais) {
        this.nomeCompanhia = nomeCompanhia;
        this.idPais = idPais;

    }

    public String getNomeCompanhia() {
        return nomeCompanhia;
    }

    public Long getIdPais() {
        return idPais;
    }


    public Companhia toModel(Pais pais){

        return new Companhia(nomeCompanhia, pais);
    }

}
