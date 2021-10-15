package treino.com.br.siteviagens.aeroportos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import treino.com.br.siteviagens.pais.Pais;
import treino.com.br.siteviagens.pais.PaisRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/aeroportos")
public class AeroportosController {

    @Autowired
    private AeroportosRepository aeroportosRepository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AeroportosResponse> cadastro(@RequestBody @Valid AeroportosRequest request) {

        Pais pais = paisRepository.getById(request.getIdPais());

        Aeroporto aeroporto = request.toModel(pais);
        aeroporto =  aeroportosRepository.save(aeroporto); // assim retornamos o id para a request (aeroporto =...)

        URI toUri = ServletUriComponentsBuilder.fromCurrentRequest().
                buildAndExpand("/{id}", aeroporto.getIdAeroporto()).toUri();

        return ResponseEntity.created(toUri).body(new AeroportosResponse(aeroporto));

    }
}