package com.example.app.denuncia;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.app.denuncia.DTO.DenunciaReturnDTO;
import com.example.app.denuncia.DTO.DenunciaSaveDTO;

import lombok.*;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "denuncias")
public class Denuncia {
    @Id
    private String identifier;
    private String nome;
    private String dataEnchente;
    private String local;
    private String relato;
    private Double mmChovido;
    private Double previsao;
    private String dataDenuncia;

    public static DenunciaReturnDTO covDenunciaReturnDTO(Denuncia d){
        return new DenunciaReturnDTO(d.getIdentifier(),d.getNome(),d.getDataEnchente(),d.getLocal(),d.getRelato(),d.getMmChovido(),d.getPrevisao(),d.getDataDenuncia());
    }

    public static Denuncia covDenuncia (DenunciaSaveDTO d){
        return new Denuncia(UUID.randomUUID().toString(),d.getNome(),d.getDataEnchente(),d.getLocal(),d.getRelato(),null,null,null);
    }
}
