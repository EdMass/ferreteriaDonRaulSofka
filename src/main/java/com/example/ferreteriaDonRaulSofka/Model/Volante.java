package com.example.ferreteriaDonRaulSofka.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "volante")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Volante {
    @Id
    private String id;
    @NonNull private List<Producto> listaInventario;
    @NonNull private LocalDate fecha;
}
