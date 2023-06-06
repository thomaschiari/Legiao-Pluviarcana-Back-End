package com.example.app.denuncia.DTO;

import lombok.*;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class DenunciaSaveDTO {
    private String nome;

    private String dataEnchente;

    private String local;

    private String relato;

    private String idade;

    private String link;

    private String mediaType;
}
