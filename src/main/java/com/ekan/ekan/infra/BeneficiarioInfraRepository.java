package com.ekan.ekan.infra;

import com.ekan.ekan.application.repository.BeneficiarioRepository;
import com.ekan.ekan.domain.Beneficiario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Log4j2
@RequiredArgsConstructor
@EnableMongoRepositories
@Repository
public class BeneficiarioInfraRepository implements BeneficiarioRepository {
    public final BeneficiarioSpringDataJPARepository beneficiarioSpringDataJPARepository;
    @Override
    public Beneficiario salva(Beneficiario beneficiario) {
        log.info("[inicia] BeneficiarioInfraRepository - salva");
        Beneficiario novoBeneficiario = beneficiarioSpringDataJPARepository.save(beneficiario);
        log.info("[finaliza] BeneficiarioInfraRepository - salva");
        return beneficiario;
    }
}
