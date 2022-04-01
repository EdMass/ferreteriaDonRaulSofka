package com.example.ferreteriaDonRaulSofka.Controller;

import com.example.ferreteriaDonRaulSofka.DTO.ClienteDTO;
import com.example.ferreteriaDonRaulSofka.DTO.VendedorDTO;
import com.example.ferreteriaDonRaulSofka.Model.Vendedor;
import com.example.ferreteriaDonRaulSofka.Services.VendedorServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class VendedorController {
    @Autowired
    VendedorServices vendedorServices;
    ModelMapper mapper;

    public VendedorController(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("/vendedores")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Vendedor> save(@RequestBody VendedorDTO vendedorDTO) {
        var vendedor = mapper.map(vendedorDTO, Vendedor.class);
        return this.vendedorServices.save(vendedor);
    }

    @GetMapping("/vendedores")
    public Flux<VendedorDTO> findAll() {
        return this.vendedorServices.findAll()
                .flatMap(v -> Mono.just(mapper.map(v, VendedorDTO.class)));
    }

    @GetMapping("/vendedores/{id}")
    public Mono<VendedorDTO> findById(@PathVariable("id") String id){
        var vendedorDTOMono = this.vendedorServices.findById(id)
                .flatMap(v -> Mono.just(mapper.map(v, VendedorDTO.class)));
        return vendedorDTOMono;
    }

    @GetMapping("/vendedor/{idVendedor}/byidVendedor")
    private Flux<VendedorDTO> findAllByidVendedor(@PathVariable("idVendedor") String idVendedor) {
        return this.vendedorServices.findByIdCliente(idVendedor)
                .flatMap(v -> Mono.just(mapper.map(v, VendedorDTO.class)));
    }

    @PutMapping("/vendedor/{id}")
    private Mono<ResponseEntity<Vendedor>> update(@PathVariable("id") String id, @RequestBody VendedorDTO vendedorDTO) {
        var vendedor = mapper.map(vendedorDTO, Vendedor.class);
        return this.vendedorServices.update(id, vendedor)
                .flatMap(v -> Mono.just(ResponseEntity.ok(v)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/vendedor/{id}")
    private Mono<ResponseEntity<Vendedor>> delete(@PathVariable("id") String id) {
        return this.vendedorServices.delete(id)
                .flatMap(v -> Mono.just(ResponseEntity.ok(v)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
