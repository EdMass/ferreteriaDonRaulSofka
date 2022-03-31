package com.example.ferreteriaDonRaulSofka.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.HashMap;

@Document(collection = "factura")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode
public class Factura {

    @Id
    private Integer id;
    private LocalDate fecha;
    private String nombreCliente;
    private String nombreProveedor;
    private Integer total;
    private HashMap<Producto, Integer> listaProductos;
}
