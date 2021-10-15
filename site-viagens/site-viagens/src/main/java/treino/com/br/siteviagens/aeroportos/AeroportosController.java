package treino.com.br.siteviagens.aeroportos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

public class AeroportosController {

    @Autowired
    private AeroportosRepository aeroportosRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AeroportosResponse> cadastro(@RequestBody @Valid AeroportosRequest request) {

        Aeroportos aeroportos = request.toModel();
        aeroportosRepository.save(aeroportos);

        AeroportosResponse response = new AeroportosResponse(aeroportos);
        URI toUri = ServletUriComponentsBuilder.fromCurrentRequest().
                buildAndExpand("/{id}", aeroportos.getIdAeroporto()).toUri();

        return ResponseEntity.created(toUri).body(response);

    }
}