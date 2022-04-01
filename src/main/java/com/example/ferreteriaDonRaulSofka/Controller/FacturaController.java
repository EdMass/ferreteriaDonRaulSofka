package com.example.ferreteriaDonRaulSofka.Controller;

import com.example.ferreteriaDonRaulSofka.DTO.FacturaDTO;
import com.example.ferreteriaDonRaulSofka.Model.Factura;
import com.example.ferreteriaDonRaulSofka.Services.FacturaServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FacturaController {
    @Autowired
    FacturaServices facturaServices;
    ModelMapper mapper;

    public FacturaController(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("/facturas")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Factura> save(@RequestBody FacturaDTO facturaDTO) {
        var factura = mapper.map(facturaDTO, Factura.class);
        return this.facturaServices.save(factura);
    }

    @GetMapping("/facturas")
    public Flux<FacturaDTO> findAll() {
        return this.facturaServices.findAll()
                .flatMap(f -> Mono.just(mapper.map(f, FacturaDTO.class)));
    }

    @GetMapping("/factura/{id}")
    public Mono<FacturaDTO> findById(@PathVariable("id") String id){
        var facturaDTOMono = this.facturaServices.findById(id)
                .flatMap(c -> Mono.just(mapper.map(c, FacturaDTO.class)));
        return facturaDTOMono;
    }

    @DeleteMapping("/factura/{id}")
    private Mono<ResponseEntity<Factura>> delete(@PathVariable("id") String id) {
        return this.facturaServices.delete(id)
                .flatMap(f -> Mono.just(ResponseEntity.ok(f)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
