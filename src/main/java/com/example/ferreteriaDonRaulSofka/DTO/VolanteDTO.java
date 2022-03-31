package com.example.ferreteriaDonRaulSofka.DTO;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode
public class VolanteDTO {
    @Id
    private String id;
    private HashMap<String, Integer> listaInventario;
    private LocalDate fecha;
}
