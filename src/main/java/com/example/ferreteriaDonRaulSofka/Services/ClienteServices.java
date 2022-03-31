package com.example.ferreteriaDonRaulSofka.Services;

import com.example.ferreteriaDonRaulSofka.Model.Cliente;
import com.example.ferreteriaDonRaulSofka.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteServices {
    @Autowired
    ClienteRepository clienteRepository;

    public Mono<Cliente> save (Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    public Flux<Cliente> findAll(){
        return this.clienteRepository.findAll();
    }

    public Mono<Cliente> findById(String id) {
        return this.clienteRepository.findById(id);
    }

    public Mono<Cliente> update(String id, Cliente cliente) {
        return this.clienteRepository.findById(id)
                .flatMap(c -> {
                    c.setCelular(cliente.getCelular());
                    c.setNombre(cliente.getNombre());
                    return save(c);
                })
                .switchIfEmpty(Mono.empty());
    }

    public Mono<Cliente> delete(String id) {
        return this.clienteRepository
                .findById(id)
                .flatMap(p -> this.clienteRepository.deleteById(p.getId()).thenReturn(p));
    }



}
