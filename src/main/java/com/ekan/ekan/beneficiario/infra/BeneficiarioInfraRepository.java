package com.ekan.ekan.beneficiario.infra;

import com.ekan.ekan.beneficiario.application.repository.BeneficiarioRepository;
import com.ekan.ekan.beneficiario.domain.Beneficiario;
import com.ekan.ekan.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

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

    @Override
    public List<Beneficiario> listaTodosBeneficiarios() {
        log.info("[inicia] BeneficiarioInfraRepository - listaTodosBeneficiarios");
        List<Beneficiario> beneficiarios = beneficiarioSpringDataJPARepository.findAll();
        log.info("[finaliza] BeneficiarioInfraRepository - listaTodosBeneficiarios");
        return beneficiarios;
    }

    @Override
    public void deletaBeneficiario(UUID idBeneficiario) {
        log.info("[inicia] BeneficiarioInfraRepository - deletaBeneficiario");
        beneficiarioSpringDataJPARepository.deleteById(idBeneficiario);
        log.info("[finaliza] BeneficiarioInfraRepository - deletaBeneficiario");

    }

    @Override
    public Beneficiario buscaBeneficiarioPorId(UUID idBeneficiario) {
        log.info("[inicia] BeneficiarioInfraRepository - buscaBeneficiarioPorId");
        Beneficiario beneficiario = beneficiarioSpringDataJPARepository.findById(idBeneficiario)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Beneficiario não encontrado"));
        log.info("[finaliza] BeneficiarioInfraRepository - buscaBeneficiarioPorId");
        return beneficiario;
    }
}
