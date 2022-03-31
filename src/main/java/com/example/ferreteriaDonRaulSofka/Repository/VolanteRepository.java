package com.example.ferreteriaDonRaulSofka.Repository;

import com.example.ferreteriaDonRaulSofka.Model.Volante;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VolanteRepository extends ReactiveMongoRepository<Volante, String> {
}
