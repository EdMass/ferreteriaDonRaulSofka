package com.example.ferreteriaDonRaulSofka.Repository;

import com.example.ferreteriaDonRaulSofka.Model.Vendedor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface VendedorRepository extends ReactiveMongoRepository<Vendedor, String> {
    Flux<Vendedor> findByIdVendedor(String idVendedor);
}
