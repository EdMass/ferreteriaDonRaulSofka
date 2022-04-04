package com.example.ferreteriaDonRaulSofka.DTO;

import com.example.ferreteriaDonRaulSofka.Model.Producto;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

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
    @NonNull private List<Producto> listaProductos;
}
