package com.example.app.denuncia;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DenunciaRepository extends MongoRepository<Denuncia, String> {
    Denuncia findByIdentifier(String identifier);
}
