package com.example.ferreteriaDonRaulSofka.DTO;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class FacturaDTO {

    @Id
    private String id;
    private Integer consecutivo;
    private LocalDate fecha;
    @NonNull private String nombreCliente;
    @NonNull private String idCliente;
    @NonNull private Integer total;
    @NonNull private HashMap<String, Integer> listaProductos;
}
