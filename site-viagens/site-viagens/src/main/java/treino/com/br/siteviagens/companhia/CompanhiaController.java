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
import treino.com.br.siteviagens.pais.PaisRequest;
import treino.com.br.siteviagens.pais.PaisResponse;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/companhia")
public class CompanhiaController {

    @Autowired
    private CompanhiaRepository companhiaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<CompanhiaResponse> cadastro(@RequestBody @Valid CompanhiaRequest request) {

        Companhia companhia = request.toModel();
        companhiaRepository.save(companhia);

        CompanhiaResponse response = new CompanhiaResponse(companhia);


        URI toUri = ServletUriComponentsBuilder.fromCurrentRequest().
                buildAndExpand("/{id}", companhia.getId()).toUri();

        return ResponseEntity.created(toUri).body(response);

    }
}
