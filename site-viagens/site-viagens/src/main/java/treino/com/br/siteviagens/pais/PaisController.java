package treino.com.br.siteviagens.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/pais")
public class PaisController {


    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<PaisResponse> cadastro(@RequestBody @Valid PaisRequest request) {

        Pais pais = request.toModel();
        
        //passa o objetio pais = paisRepository para o banco retornar o
        // id para o front, se deixar sem o objeto ele rertornará somente
        // os dados preenchidos na requisição (nesse caso, o nome)
        pais = paisRepository.save(pais);

        PaisResponse response = new PaisResponse(pais);


        URI toUri = ServletUriComponentsBuilder.fromCurrentRequest().
                buildAndExpand("/{id}", pais.getId()).toUri();

        return ResponseEntity.created(toUri).body(response);

    }


}
