package com.example.ferreteriaDonRaulSofka.Repository;

import com.example.ferreteriaDonRaulSofka.Model.Proveedor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface ProveedorRepository extends ReactiveMongoRepository<Proveedor, String> {
    Flux<Proveedor> findByIdProveedor(String idProveedor);
}
