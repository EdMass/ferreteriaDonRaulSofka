package com.example.ferreteriaDonRaulSofka.Controller;

import com.example.ferreteriaDonRaulSofka.DTO.ClienteDTO;
import com.example.ferreteriaDonRaulSofka.Model.Cliente;
import com.example.ferreteriaDonRaulSofka.Services.ClienteServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {
    @Autowired
    ClienteServices clienteServices;
    ModelMapper mapper;

    public ClienteController(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Cliente> save(@RequestBody ClienteDTO clienteDTO) {
        var cliente = mapper.map(clienteDTO, Cliente.class);
        return this.clienteServices.save(cliente);
    }

    @GetMapping("/clientes")
    public Flux<ClienteDTO> findAll() {
        return this.clienteServices.findAll()
                .flatMap(c -> Mono.just(mapper.map(c, ClienteDTO.class)));
    }

    @GetMapping("/cliente/{id}")
    public Mono<ClienteDTO> findById(@PathVariable("id") String id){
        var cliente = this.clienteServices.findById(id)
                .flatMap(c -> Mono.just(mapper.map(c, ClienteDTO.class)));
        return cliente;
    }

    @GetMapping("/cliente/{idCliente}/byidCliente")
    private Flux<ClienteDTO> findAllByidCliente(@PathVariable("idCliente") String idCliente) {
        return this.clienteServices.findByIdCliente(idCliente)
                .flatMap(c -> Mono.just(mapper.map(c, ClienteDTO.class)));
    }

    @PutMapping("/cliente/{id}")
    private Mono<ResponseEntity<Cliente>> update(@PathVariable("id") String id, @RequestBody ClienteDTO clienteDTO) {
        var cliente = mapper.map(clienteDTO, Cliente.class);
        return this.clienteServices.update(id, cliente)
                .flatMap(c1 -> Mono.just(ResponseEntity.ok(c1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/cliente/{id}")
    private Mono<ResponseEntity<Cliente>> delete(@PathVariable("id") String id) {
        return this.clienteServices.delete(id)
                .flatMap(c -> Mono.just(ResponseEntity.ok(c)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }


}
