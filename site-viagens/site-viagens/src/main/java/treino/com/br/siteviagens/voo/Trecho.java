package treino.com.br.siteviagens.voo;

import treino.com.br.siteviagens.rota.Rota;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.util.Objects;

@Entity
@Table(name = "trechos")
public class Trecho implements Comparable<Trecho> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Rota rota;

    @NotNull
    @ManyToOne
    private Voo voo;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private Duration tempoDeParada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Deprecated
    private Trecho() {

    }

    public Trecho(Rota rota, Voo voo, Tipo tipo, Duration tempoDeParada) {
        this.rota = rota;
        this.voo = voo;
        this.tipo = tipo;
        this.tempoDeParada = tempoDeParada;
    }

    @Override
    public int compareTo(Trecho trecho) {
        if (this == trecho || this.equals(trecho) || rota.equals(trecho.rota)) {
            return 0;
        }

        if (rota.getAeroportoDestino().equals(trecho.rota.getAeroportoOrigem())) {
            return -1;
        }

        if (rota.getAeroportoOrigem().equals(trecho.rota.getAeroportoDestino())) {
            return 1;
        }

        throw new IllegalArgumentException("trechos nao possuem ordem logica");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trecho trecho = (Trecho) o;
        return rota.equals(trecho.rota) &&
                voo.equals(trecho.voo) &&
                tipo == trecho.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rota, voo, tipo);
    }
}
