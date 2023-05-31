package com.example.app.denuncia;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "denuncias")
public class Denuncia {

    @Id
    private Integer id;

    private String identifier;
    
    private String nome;

    private String dataEnchente;

    private String local;

    private String relato;

    private Double mmChovido;

    private Double previsao;

    private String dataDenuncia;
    
}
