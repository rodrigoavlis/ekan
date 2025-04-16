package com.ekan.ekan.infra;

import com.ekan.ekan.domain.Beneficiario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface BeneficiarioSpringDataJPARepository extends MongoRepository <Beneficiario, UUID> {
}
