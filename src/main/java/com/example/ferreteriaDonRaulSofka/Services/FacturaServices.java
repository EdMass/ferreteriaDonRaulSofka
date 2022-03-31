package com.example.ferreteriaDonRaulSofka.Services;

import com.example.ferreteriaDonRaulSofka.Model.Factura;
import com.example.ferreteriaDonRaulSofka.Repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FacturaServices {
    @Autowired
    FacturaRepository facturaRepository;

    public Mono<Factura> save (Factura factura){
        return this.facturaRepository.save(factura);
    }

    public Flux<Factura> findAll(){
        return this.facturaRepository.findAll();
    }

    public Mono<Factura> findById(String id) {
        return this.facturaRepository.findById(id);
    }
}
