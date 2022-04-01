package com.example.ferreteriaDonRaulSofka.Controller;

import com.example.ferreteriaDonRaulSofka.DTO.ProductoDTO;
import com.example.ferreteriaDonRaulSofka.Model.Producto;
import com.example.ferreteriaDonRaulSofka.Services.ProductoServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductoController {
    @Autowired
    ProductoServices productoServices;
    ModelMapper mapper;

    public ProductoController(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("/productos")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Producto> save(@RequestBody ProductoDTO productoDTO) {
        var producto = mapper.map(productoDTO, Producto.class);
        return this.productoServices.save(producto);
    }

    @GetMapping("/productos")
    public Flux<ProductoDTO> findAll() {
        return this.productoServices.findAll()
                .flatMap(c -> Mono.just(mapper.map(c, ProductoDTO.class)));
    }

    @GetMapping("/producto/{id}")
    public Mono<ProductoDTO> findById(@PathVariable("id") String id){
        var productoDTOMono = this.productoServices.findById(id)
                .flatMap(c -> Mono.just(mapper.map(c, ProductoDTO.class)));
        return productoDTOMono;
    }

    @PutMapping("/producto/{id}")
    private Mono<ResponseEntity<Producto>> update(@PathVariable("id") String id, @RequestBody ProductoDTO productoDTO) {
        var producto = mapper.map(productoDTO, Producto.class);
        return this.productoServices.update(id, producto)
                .flatMap(p1 -> Mono.just(ResponseEntity.ok(p1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/producto/{id}")
    private Mono<ResponseEntity<Producto>> delete(@PathVariable("id") String id) {
        return this.productoServices.delete(id)
                .flatMap(p -> Mono.just(ResponseEntity.ok(p)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
