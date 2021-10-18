package treino.com.br.siteviagens.rota;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import treino.com.br.siteviagens.companhia.Companhia;
import treino.com.br.siteviagens.companhia.CompanhiaResponse;
import treino.com.br.siteviagens.pais.Pais;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/rotas")
public class RotaController {

    @Autowired
    private RotaRepository rotaRepository;


    @PostMapping
    @Transactional
    public ResponseEntity<RotaResponse> cadastro(@RequestBody @Valid RotaRequest request){

        
        Rota rota = request.toModel(rota);
        rotaRepository.save(rota);

        URI toUri = ServletUriComponentsBuilder.fromCurrentRequest().
                buildAndExpand("/{id}", rota.getId()).toUri();

        return ResponseEntity.created(toUri).body(new CompanhiaResponse(rota));

}
