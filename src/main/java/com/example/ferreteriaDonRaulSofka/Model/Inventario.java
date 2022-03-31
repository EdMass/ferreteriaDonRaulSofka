package com.example.ferreteriaDonRaulSofka.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document(collection = "inventario")
@Getter
@Setter
@EqualsAndHashCode
public class Inventario {

    @Id
    private String id;
    private HashMap<Producto, Integer> listaInventario;

}
