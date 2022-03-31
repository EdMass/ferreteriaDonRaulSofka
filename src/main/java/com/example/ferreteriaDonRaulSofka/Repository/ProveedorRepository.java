package com.example.ferreteriaDonRaulSofka.Repository;

import com.example.ferreteriaDonRaulSofka.Model.Proveedor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProveedorRepository extends ReactiveMongoRepository<Proveedor, String> {
}
