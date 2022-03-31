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
    private Integer id;
    private LocalDate fecha;
    private String nombreCliente;
    private String nombreProveedor;
    private Integer total;
    private HashMap<String, Integer> listaProductos;
}
