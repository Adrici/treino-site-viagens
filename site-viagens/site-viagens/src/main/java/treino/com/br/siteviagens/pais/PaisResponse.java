package treino.com.br.siteviagens.pais;

import javax.validation.constraints.NotBlank;

public class PaisResponse {

    private Long id;
    private String nome;

    public PaisResponse(Pais pais) {
        this.id = pais.getId();
        this.nome = pais.getNome();
    }



    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
