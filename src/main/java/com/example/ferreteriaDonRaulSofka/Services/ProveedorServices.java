package com.example.ferreteriaDonRaulSofka.Services;

import com.example.ferreteriaDonRaulSofka.Model.Cliente;
import com.example.ferreteriaDonRaulSofka.Model.Proveedor;
import com.example.ferreteriaDonRaulSofka.Repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProveedorServices {
    @Autowired
    ProveedorRepository proveedorRepository;

    public Mono<Proveedor> save (Proveedor proveedor){
        return this.proveedorRepository.save(proveedor);
    }

    public Flux<Proveedor> findAll(){
        return this.proveedorRepository.findAll();
    }

    public Mono<Proveedor> findById(String id) {
        return this.proveedorRepository.findById(id);
    }
}
