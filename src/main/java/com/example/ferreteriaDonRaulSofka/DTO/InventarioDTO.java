package com.example.ferreteriaDonRaulSofka.DTO;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode
public class InventarioDTO {

    @Id
    private String id;
    private HashMap<ProductoDTO, Integer> listaInventario;

}
