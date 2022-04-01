package com.example.ferreteriaDonRaulSofka.Services;

import com.example.ferreteriaDonRaulSofka.Model.Factura;
import com.example.ferreteriaDonRaulSofka.Repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Comparator;

@Service
public class FacturaServices {
    @Autowired
    FacturaRepository facturaRepository;

    public Mono<Factura> save (Factura factura){
        Factura f = new Factura();
        f.setConsecutivo(factura.getConsecutivo());
        f.setFecha(LocalDate.now());
        f.setListaProductos(factura.getListaProductos());
        f.setNombreCliente(factura.getNombreCliente());
        f.setIdCliente(factura.getIdCliente());
        f.setTotal(factura.getTotal());
        return this.facturaRepository.save(f);
    }

    public Flux<Factura> findAll(){
        return this.facturaRepository.findAll();
    }

    public Mono<Factura> findById(String id) {
        return this.facturaRepository.findById(id);
    }

    public Mono<Factura> delete(String id) {
        return this.facturaRepository
                .findById(id)
                .flatMap(p -> this.facturaRepository.deleteById(p.getId()).thenReturn(p));
    }



}
