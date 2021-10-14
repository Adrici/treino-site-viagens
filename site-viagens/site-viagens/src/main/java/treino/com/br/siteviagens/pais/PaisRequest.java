package treino.com.br.siteviagens.pais;


import javax.validation.constraints.NotBlank;

// A Request éo lugar onde iremos fazer e retirar a menssagem que queremos
public class PaisRequest {

    @NotBlank
    private String nome;

    public PaisRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Pais toModel(){
        return new Pais(this.nome);
    }


}
