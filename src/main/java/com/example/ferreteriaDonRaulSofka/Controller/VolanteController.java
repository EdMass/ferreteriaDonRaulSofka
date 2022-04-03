package com.example.ferreteriaDonRaulSofka.Controller;

import com.example.ferreteriaDonRaulSofka.DTO.VolanteDTO;
import com.example.ferreteriaDonRaulSofka.Model.Volante;
import com.example.ferreteriaDonRaulSofka.Services.VolanteServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VolanteController {
    @Autowired
    VolanteServices volanteServices;
    ModelMapper mapper;

    public VolanteController(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("/volantes")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Volante> save(@RequestBody VolanteDTO volanteDTO) {
        var volante = mapper.map(volanteDTO, Volante.class);
        return this.volanteServices.save(volante);
    }

    @GetMapping("/volantes")
    public Flux<VolanteDTO> findAll() {
        return this.volanteServices.findAll()
                .flatMap(v -> Mono.just(mapper.map(v, VolanteDTO.class)));
    }

    @GetMapping("/volante/{id}")
    public Mono<VolanteDTO> findById(@PathVariable("id") String id){
        var volante = this.volanteServices.findById(id)
                .flatMap(v -> Mono.just(mapper.map(v, VolanteDTO.class)));
        return volante;
    }

    @DeleteMapping("/volante/{id}")
    private Mono<ResponseEntity<Volante>> delete(@PathVariable("id") String id) {
        return this.volanteServices.delete(id)
                .flatMap(c -> Mono.just(ResponseEntity.ok(c)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

}
