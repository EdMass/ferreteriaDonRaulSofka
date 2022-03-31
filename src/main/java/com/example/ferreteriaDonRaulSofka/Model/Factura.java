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
    @NonNull private String nombreCliente;
    @NonNull private Integer total;
    @NonNull private HashMap<String, Integer> listaProductos;
}
