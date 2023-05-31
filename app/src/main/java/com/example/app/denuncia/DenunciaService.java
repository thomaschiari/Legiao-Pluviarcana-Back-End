package com.example.app.denuncia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.app.denuncia.DTO.*;

public class DenunciaService {
    
    @Autowired
    DenunciaRepository denunciaRepository;

    public List<DenunciaReturnDTO> listAll(){
        ArrayList<DenunciaReturnDTO> denuncias = new ArrayList<DenunciaReturnDTO>();
        for (Denuncia d : denunciaRepository.findAll()) {
            denuncias.add(Denuncia.covDenunciaReturnDTO(d));
        }
        return denuncias;
    }

    public DenunciaReturnDTO saveDenuncia(DenunciaSaveDTO d){
        RestTemplate restTemplate = new RestTemplate();

        Denuncia denuncia = Denuncia.covDenuncia(d);

        // TODO fazer as chamadas de API aqui e setar as partes da denuncia
        // ResponseEntity<GameReturnDTO> response =
        //         restTemplate.getForEntity("http://localhost:8080/game/" + identifier, GameReturnDTO.class);
        // if (response.getStatusCode().is2xxSuccessful()) {
        //     return response.getBody();
        // }


        // ------------------------------
        denunciaRepository.save(denuncia);


        return Denuncia.covDenunciaReturnDTO(denuncia);
    }


    public DenunciaReturnDTO getDenunciaReturnDTO(String identifier){
        return Denuncia.covDenunciaReturnDTO(denunciaRepository.findByIdentifier(identifier));
    }




}
