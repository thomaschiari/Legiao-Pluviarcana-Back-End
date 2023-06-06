package com.example.app.denuncia.DTO;

import lombok.*;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class DenunciaReturnDTO {
    private Integer identifier;
    
    private String nome;

    private String dataEnchente;

    private String local;

    private String relato;

    private String idade;

    private String link;

    private Double mmChovido;

    private Double previsao;

    private String dataDenuncia;
}
