package com.example.app.denuncia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.denuncia.DTO.DenunciaReturnDTO;
import com.example.app.denuncia.DTO.DenunciaSaveDTO;

@RestController
@RequestMapping("/")
public class DenunciaController {
    @Autowired
    DenunciaService denunciaService;

    @PostMapping
    public DenunciaReturnDTO save(@RequestBody DenunciaSaveDTO d){
        return denunciaService.saveDenuncia(d);
    }
}
