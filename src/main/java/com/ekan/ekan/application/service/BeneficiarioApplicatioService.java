package com.ekan.ekan.application.service;

import com.ekan.ekan.application.api.BeneficiarioRequest;
import com.ekan.ekan.application.api.BeneficiarioResponse;
import com.ekan.ekan.application.repository.BeneficiarioRepository;
import com.ekan.ekan.domain.Beneficiario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class BeneficiarioApplicatioService implements BeneficiarioService {
    public final BeneficiarioRepository beneficiarioRepository;
    @Override
    public BeneficiarioResponse criaNovoBeneficiario(BeneficiarioRequest beneficiarioRequest) {
        log.info("[inicia] BeneficiarioApplicatioService - criaNovoBeneficiario");
        Beneficiario beneficiario = beneficiarioRepository.salva(new Beneficiario(beneficiarioRequest));
        log.info("[finaliza] BeneficiarioApplicatioService - criaNovoBeneficiario");
        return new BeneficiarioResponse(beneficiario);
    }
}
