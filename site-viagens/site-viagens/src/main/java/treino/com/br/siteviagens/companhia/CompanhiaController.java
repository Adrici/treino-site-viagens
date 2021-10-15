package treino.com.br.siteviagens.companhia;

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
@RequestMapping("/companhias")
public class CompanhiaController {

    @Autowired
    private CompanhiaRepository companhiaRepository;

    @Autowired
    private PaisRepository paisRepository;


    @PostMapping
    @Transactional
    public ResponseEntity<CompanhiaResponse> cadastro(@RequestBody @Valid CompanhiaRequest request) {

        Pais pais = paisRepository.getById(request.getIdPais());

        Companhia companhia = request.toModel(pais);
        companhiaRepository.save(companhia);

        URI toUri = ServletUriComponentsBuilder.fromCurrentRequest().
                buildAndExpand("/{id}", companhia.getId()).toUri();

        return ResponseEntity.created(toUri).body(new CompanhiaResponse(companhia));

    }
}
