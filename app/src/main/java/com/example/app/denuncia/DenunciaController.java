package com.example.app.denuncia;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.denuncia.DTO.*;

@RestController
@RequestMapping("/denuncia")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DenunciaController {
    @Autowired
    DenunciaService denunciaService;

    @GetMapping
    public List<DenunciaReturnDTO> listAll(){return denunciaService.listAll();}

    @PostMapping
    public DenunciaReturnDTO saveDenuncia(@RequestBody DenunciaPostDTO d){
        return denunciaService.saveDenuncia(d);
    }

    @GetMapping("/{identifier}")
    public DenunciaReturnDTO getDenuncia(@PathVariable Integer identifier){return denunciaService.getDenuncia(identifier);}

    @DeleteMapping("/delete/{identifier}")
    public boolean deleteDenuncia(@PathVariable Integer identifier){return denunciaService.deleteDenuncia(identifier);} 
}
