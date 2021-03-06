package treino.com.br.siteviagens.voo;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "voos")
public class Voo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive
    @Min(1)
    private int lugaresDisponiveis;

   @Deprecated
    public Voo() {
    }

    public Voo(Long id, int lugaresDisponiveis) {
        this.id = id;
        this.lugaresDisponiveis = lugaresDisponiveis;
    }

    public Long getId() {
        return id;
    }

    public int getLugaresDisponiveis() {
        return lugaresDisponiveis;
    }
}
