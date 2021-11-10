package treino.com.br.siteviagens.voo;


public class VooResponse {

    private Long id;
    private int lugaresDisponiveis;


    public VooResponse(Voo voo){
        this.id = voo.getId();
        this.lugaresDisponiveis = voo.getLugaresDisponiveis();
    }

    public Long getId() {
        return id;
    }

    public int getLugaresDisponiveis() {
        return lugaresDisponiveis;
    }
}
