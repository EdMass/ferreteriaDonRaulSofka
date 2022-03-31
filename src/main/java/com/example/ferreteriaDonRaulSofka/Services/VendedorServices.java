package com.example.ferreteriaDonRaulSofka.Services;

import com.example.ferreteriaDonRaulSofka.Model.Cliente;
import com.example.ferreteriaDonRaulSofka.Model.Vendedor;
import com.example.ferreteriaDonRaulSofka.Repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VendedorServices {
    @Autowired
    VendedorRepository vendedorRepository;

    public Mono<Vendedor> save (Vendedor vendedor){
        return this.vendedorRepository.save(vendedor);
    }

    public Flux<Vendedor> findAll(){
        return this.vendedorRepository.findAll();
    }

    public Mono<Vendedor> findById(String id) {
        return this.vendedorRepository.findById(id);
    }

    public Mono<Vendedor> update(String id, Vendedor vendedor) {
        return this.vendedorRepository.findById(id)
                .flatMap(v -> {
                    v.setId(vendedor.getId());
                    v.setCelular(vendedor.getCelular());
                    v.setNombre(vendedor.getNombre());
                    return save(v);
                })
                .switchIfEmpty(Mono.empty());
    }

    public Mono<Vendedor> delete(String id) {
        return this.vendedorRepository
                .findById(id)
                .flatMap(p -> this.vendedorRepository.deleteById(p.getId()).thenReturn(p));
    }
}
