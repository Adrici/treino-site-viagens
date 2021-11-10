package treino.com.br.siteviagens.voo;

import treino.com.br.siteviagens.rota.Rota;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

public class VooRequest {
    @Positive
    @Min(1)
    private int lugaresDisponiveis;

    public VooRequest(int lugaresDisponiveis) {
        this.lugaresDisponiveis = lugaresDisponiveis;
    }

    public int getLugaresDisponiveis() {
        return lugaresDisponiveis;
    }

    //toModel

}
