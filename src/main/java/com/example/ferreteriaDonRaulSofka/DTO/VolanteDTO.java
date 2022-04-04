package com.example.ferreteriaDonRaulSofka.DTO;

import com.example.ferreteriaDonRaulSofka.Model.Producto;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode
public class VolanteDTO {
    @Id
    private String id;
    private List<Producto> listaInventario;
    private LocalDate fecha;
}
