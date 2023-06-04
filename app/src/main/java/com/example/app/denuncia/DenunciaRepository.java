package com.example.app.denuncia;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DenunciaRepository extends MongoRepository<Denuncia, String> {
    @Query("{identifier:?0}")
    Denuncia findByIdentifier(String identifier);
}
