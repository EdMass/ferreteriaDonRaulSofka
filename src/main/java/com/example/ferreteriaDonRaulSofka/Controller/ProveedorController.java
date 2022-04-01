package com.example.ferreteriaDonRaulSofka.Controller;

import com.example.ferreteriaDonRaulSofka.DTO.ProveedorDTO;
import com.example.ferreteriaDonRaulSofka.DTO.VendedorDTO;
import com.example.ferreteriaDonRaulSofka.Model.Proveedor;
import com.example.ferreteriaDonRaulSofka.Services.ProveedorServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProveedorController {
    @Autowired
    ProveedorServices proveedorServices;

    ModelMapper mapper;

    public ProveedorController(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("/proveedores")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Proveedor> save(@RequestBody ProveedorDTO proveedorDTO) {
        var proveedor = mapper.map(proveedorDTO, Proveedor.class);
        return this.proveedorServices.save(proveedor);
    }

    @GetMapping("/proveedores")
    public Flux<ProveedorDTO> findAll() {
        return this.proveedorServices.findAll()
                .flatMap(p -> Mono.just(mapper.map(p, ProveedorDTO.class)));
    }

    @GetMapping("/proveedor/{id}")
    public Mono<ProveedorDTO> findById(@PathVariable("id") String id){
        var proveedorDTOMono = this.proveedorServices.findById(id)
                .flatMap(c -> Mono.just(mapper.map(c, ProveedorDTO.class)));
        return proveedorDTOMono;
    }

    @GetMapping("/proveedor/{idProveedor}/byidProveedor")
    private Flux<ProveedorDTO> findAllByidProveedor(@PathVariable("idProveedor") String idProveedor) {
        return this.proveedorServices.findByIdCliente(idProveedor)
                .flatMap(v -> Mono.just(mapper.map(v, ProveedorDTO.class)));
    }

    @PutMapping("/proveedor/{id}")
    private Mono<ResponseEntity<Proveedor>> update(@PathVariable("id") String id, @RequestBody ProveedorDTO proveedorDTO) {
        var proveedor = mapper.map(proveedorDTO, Proveedor.class);
        return this.proveedorServices.update(id, proveedor)
                .flatMap(c1 -> Mono.just(ResponseEntity.ok(c1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/proveedor/{id}")
    private Mono<ResponseEntity<Proveedor>> delete(@PathVariable("id") String id) {
        return this.proveedorServices.delete(id)
                .flatMap(p -> Mono.just(ResponseEntity.ok(p)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

}
