package com.example.ferreteriaDonRaulSofka.DTO;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode
public class ProveedorDTO {

    @Id
    private String id;
    @NonNull private String nombre;
    private String celular;
    @NonNull private String idProveedor;

}
