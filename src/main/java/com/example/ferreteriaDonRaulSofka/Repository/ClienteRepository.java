package com.example.ferreteriaDonRaulSofka.Repository;

import com.example.ferreteriaDonRaulSofka.Model.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClienteRepository extends ReactiveMongoRepository<Cliente, String> {

}
