package com.ekan.ekan.beneficiario.infra;

import com.ekan.ekan.beneficiario.domain.Beneficiario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface BeneficiarioSpringDataJPARepository extends MongoRepository <Beneficiario, UUID> {
}
