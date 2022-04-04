package com.example.ferreteriaDonRaulSofka.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "factura")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode
public class Factura {

    @Id
    private String id;
    private Integer consecutivo;
    private LocalDate fecha;
    @NonNull private String nombreCliente;
    @NonNull private String idCliente;
    @NonNull private Integer total;
    @NonNull private List<Producto> listaProductos;

}
