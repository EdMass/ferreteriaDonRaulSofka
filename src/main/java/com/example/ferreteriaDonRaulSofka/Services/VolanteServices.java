package com.example.ferreteriaDonRaulSofka.Services;

import com.example.ferreteriaDonRaulSofka.Model.Cliente;
import com.example.ferreteriaDonRaulSofka.Model.Volante;
import com.example.ferreteriaDonRaulSofka.Repository.VolanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VolanteServices {
    @Autowired
    VolanteRepository volanteRepository;

    public Mono<Volante> save (Volante volante){
        return this.volanteRepository.save(volante);
    }

    public Flux<Volante> findAll(){
        return this.volanteRepository.findAll();
    }

    public Mono<Volante> findById(String id) {
        return this.volanteRepository.findById(id);
    }

    public Mono<Volante> delete(String id) {
        return this.volanteRepository
                .findById(id)
                .flatMap(p -> this.volanteRepository.deleteById(p.getId()).thenReturn(p));
    }

}
