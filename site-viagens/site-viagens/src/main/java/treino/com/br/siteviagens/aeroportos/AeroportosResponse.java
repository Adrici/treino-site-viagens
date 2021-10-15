package treino.com.br.siteviagens.aeroportos;

import javax.validation.constraints.NotBlank;

public class AeroportosResponse {
    private Long idAeroporto;
    private String nomeAeroporto;

    public AeroportosResponse(Aeroportos aeroporto) {
        this.idAeroporto = aeroporto.getIdAeroporto();
        this.nomeAeroporto = aeroporto.getNomeAeroporto();
    }

    public Long getIdAeroporto() {
        return idAeroporto;
    }

    public String getNomeAeroporto() {
        return nomeAeroporto;
    }
}
