package com.example.app.denuncia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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

        Denuncia denuncia = Denuncia.covDenuncia(d);

        // TODO fazer as chamadas de API aqui e setar as partes da denuncia



        // ------------------------------


        return Denuncia.covDenunciaReturnDTO(denuncia);
    }

    



}
