package com.example.ferreteriaDonRaulSofka.Repository;

import com.example.ferreteriaDonRaulSofka.Model.Factura;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends ReactiveMongoRepository<Factura, String> {

}
