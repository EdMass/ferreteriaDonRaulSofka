package com.example.ferreteriaDonRaulSofka.Repository;

import com.example.ferreteriaDonRaulSofka.Model.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface ClienteRepository extends ReactiveMongoRepository<Cliente, String> {
    Flux<Cliente> findByIdCliente(String idCliente);
}
