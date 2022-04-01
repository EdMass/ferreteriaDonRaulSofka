package com.example.ferreteriaDonRaulSofka.Repository;

import com.example.ferreteriaDonRaulSofka.Model.Proveedor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProveedorRepository extends ReactiveMongoRepository<Proveedor, String> {
    Flux<Proveedor> findByIdProveedor(String idProveedor);
}
