package com.example.ferreteriaDonRaulSofka.Services;

import com.example.ferreteriaDonRaulSofka.Model.Producto;
import com.example.ferreteriaDonRaulSofka.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServices {
    @Autowired
    ProductoRepository productoRepository;

    public Mono<Producto> save (Producto producto){
        return this.productoRepository.save(producto);
    }

    public Flux<Producto> findAll(){
        return this.productoRepository.findAll();
    }

    public Mono<Producto> findById(String id) {
        return this.productoRepository.findById(id);
    }

    public Mono<Producto> update(String id, Producto producto) {
        return this.productoRepository.findById(id)
                .flatMap(p -> {
                    p.setId(producto.getId());
                    p.setNombreProveedor(producto.getNombreProveedor());
                    p.setNombre(producto.getNombre());
                    p.setPrecio(producto.getPrecio());
                    p.setProveedorID(producto.getProveedorID());
                    return save(p);
                })
                .switchIfEmpty(Mono.empty());
    }

    public Mono<Producto> delete(String id) {
        return this.productoRepository
                .findById(id)
                .flatMap(p -> this.productoRepository.deleteById(p.getId()).thenReturn(p));
    }
}
