package com.example.app.denuncia;

<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> ecd7d8ab540f79f8083a588ec999f0e814d10727
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.denuncia.DTO.*;

@RestController
@RequestMapping("/denuncia")
public class DenunciaController {
    @Autowired
    DenunciaService denunciaService;

    @GetMapping
    public List<DenunciaReturnDTO> listAll(){return denunciaService.listAll();}

    @PostMapping
    public DenunciaReturnDTO saveDenuncia(@RequestBody DenunciaSaveDTO d){
        return denunciaService.saveDenuncia(d);
    }

    @GetMapping("/{identifier}")
    public DenunciaReturnDTO getDenuncia(@PathVariable String identifier){return denunciaService.getDenuncia(identifier);}

    @DeleteMapping("/delete/{identifier}")
    public boolean deleteDenuncia(@PathVariable String identifier){return denunciaService.deleteDenuncia(identifier);} 
}
