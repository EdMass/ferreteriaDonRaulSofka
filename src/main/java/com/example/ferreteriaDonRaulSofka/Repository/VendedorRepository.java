package com.example.ferreteriaDonRaulSofka.Repository;

import com.example.ferreteriaDonRaulSofka.Model.Vendedor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VendedorRepository extends ReactiveMongoRepository<Vendedor, String> {
}
