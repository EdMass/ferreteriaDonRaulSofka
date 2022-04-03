package com.example.ferreteriaDonRaulSofka.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "producto")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode
public class Producto {

    @Id
    private String id;
    @NonNull private String nombre;
    @NonNull private Double precio;
    private String proveedorID;
    private String nombreProveedor;
    private Double almacenados;

}
