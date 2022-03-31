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
public class VendedorDTO {

        @Id
        private String id;
        private String nombre;
        private String celular;

}
