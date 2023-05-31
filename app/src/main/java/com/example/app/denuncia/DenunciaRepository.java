package com.example.app.denuncia;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface DenunciaRepository extends MongoRepository<Denuncia, String> {
    Denuncia findByIdentifier(String identifier);
    List<Denuncia> findByDataEnchente(String dataEnchente);
    List<Denuncia> findByDataDenuncia(String dataDenuncia);
}
