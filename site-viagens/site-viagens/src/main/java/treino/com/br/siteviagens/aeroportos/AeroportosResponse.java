package treino.com.br.siteviagens.aeroportos;

public class AeroportosResponse {
    private Long idAeroporto;
    private String nomeAeroporto;

    public AeroportosResponse(Aeroporto aeroporto) {
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
