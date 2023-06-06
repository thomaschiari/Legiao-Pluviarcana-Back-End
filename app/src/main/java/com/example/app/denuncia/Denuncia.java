package com.example.app.denuncia;


import com.example.app.denuncia.DTO.DenunciaReturnDTO;
import com.example.app.denuncia.DTO.DenunciaSaveDTO;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

@Entity
public class Denuncia {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer identifier;
    
    @NonNull
    private String nome;

    @NonNull
    private String dataEnchente;

    @NonNull
    private String local;

    @NonNull
    private String relato;

    @NonNull
    private String idade;

    private String link;


    private Double mmChovido;
    private Double previsao;
    private String dataDenuncia;

    public static DenunciaReturnDTO covDenunciaReturnDTO(Denuncia d){
        return new DenunciaReturnDTO(d.getIdentifier(),d.getNome(),d.getDataEnchente(),d.getLocal(),d.getRelato(),d.getIdade(),d.getLink(),d.getMmChovido(),d.getPrevisao(),d.getDataDenuncia());
    }

    public static Denuncia covDenuncia (DenunciaSaveDTO d){
        return new Denuncia(null,d.getNome(),d.getDataEnchente(),d.getLocal(),d.getRelato(),d.getIdade(),d.getLink(),null,null,null);
    }
}
