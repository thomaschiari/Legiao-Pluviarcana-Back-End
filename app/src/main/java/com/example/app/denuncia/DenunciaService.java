package com.example.app.denuncia;

import com.example.app.clima.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.app.denuncia.DTO.*;

@Service
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

    public DenunciaReturnDTO saveDenuncia(DenunciaPostDTO d){
        RestTemplate restTemplate = new RestTemplate();
        LocalDate now = LocalDate.now();
        DenunciaSaveDTO dd = DenunciaPostDTO.covDenunciaSaveDTO(d);
        Denuncia denuncia = Denuncia.covDenuncia(dd);

        String lat = "-23.617111";
        String lon = "-46.590950";
        String date = denuncia.getDataEnchente();
        String url =  "https://api.open-meteo.com/v1/forecast?latitude=" + lat + "&longitude=" + lon + "&hourly=precipitation&daily=precipitation_sum,precipitation_probability_mean&timezone=America/Sao_Paulo&current_weather=true&start_date=" + date + "&end_date=" + date;

        ResponseEntity<Clima> response = restTemplate.getForEntity(url, Clima.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            Clima clima = response.getBody();
            denuncia.setMmChovido(clima.getDaily().getPrecipitation_sum().get(0));   
            denuncia.setPrevisao(clima.getDaily().getPrecipitation_probability_mean().get(0));
        }
        denuncia.setDataDenuncia(now.toString());
        denunciaRepository.save(denuncia);
        return Denuncia.covDenunciaReturnDTO(denuncia);
    }

    public DenunciaReturnDTO getDenuncia(Integer identifier){
        return Denuncia.covDenunciaReturnDTO(denunciaRepository.findByIdentifier(identifier));
    }

    public boolean deleteDenuncia(Integer identifier){
        Denuncia d = denunciaRepository.findByIdentifier(identifier);
        if(d==null) return false;
        denunciaRepository.delete(d);
        return true;
    }

}
