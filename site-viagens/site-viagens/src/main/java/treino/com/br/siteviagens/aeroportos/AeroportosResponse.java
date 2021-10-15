package treino.com.br.siteviagens.aeroportos;

import javax.validation.constraints.NotBlank;

public class AeroportosResponse {
    private Long idAeroporto;
    private String nomeAeroporto;

    public AeroportosResponse(Aeroportos aeroporto) {
        this.idAeroporto = idAeroporto;
        this.nomeAeroporto = nomeAeroporto;
    }

    public Long getIdAeroporto() {
        return idAeroporto;
    }

    public String getNomeAeroporto() {
        return nomeAeroporto;
    }
}
