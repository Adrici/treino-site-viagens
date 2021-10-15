package treino.com.br.siteviagens;

import treino.com.br.siteviagens.pais.Pais;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

public class aeroportos {

    @NotBlank
    private String nomeAeroporto;

    @NotBlank
    @ManyToOne //duvida entre oneToOne
    private Pais pais;

}
