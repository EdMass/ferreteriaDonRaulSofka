package com.example.ferreteriaDonRaulSofka.DTO;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode
public class ProductoDTO {

    @Id
    @NonNull private String id;
    @NonNull private String nombre;
    @NonNull private Double precio;
    private String proveedorID;
    private String nombreProveedor;

}
