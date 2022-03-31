package com.example.ferreteriaDonRaulSofka.Repository;

import com.example.ferreteriaDonRaulSofka.Model.Factura;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface FacturaRepository extends ReactiveMongoRepository<Factura, String> {
    Factura  findTopByOrderByIdDesc();
}
