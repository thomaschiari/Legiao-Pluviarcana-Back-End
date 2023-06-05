package com.example.app.denuncia;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "denuncia", path = "denuncias")
public interface DenunciaRepository extends JpaRepository<Denuncia, String> {

    Denuncia findByIdentifier(Integer identifier);
}
