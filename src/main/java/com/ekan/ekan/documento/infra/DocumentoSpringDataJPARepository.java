package com.ekan.ekan.documento.infra;

import com.ekan.ekan.documento.domain.Documento;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;


public interface DocumentoSpringDataJPARepository extends MongoRepository<Documento, UUID> {


    List<Documento> findAllByIdBeneficiario(UUID idBeneficiario);
    void deleteByIdBeneficiario(UUID idBeneficiario);
}
