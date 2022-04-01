package com.example.ferreteriaDonRaulSofka.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vendedor")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode
public class Vendedor {

        @Id
        private String id;
        @NonNull private String nombre;
        private String celular;
        @NonNull private String idVendedor;

}
