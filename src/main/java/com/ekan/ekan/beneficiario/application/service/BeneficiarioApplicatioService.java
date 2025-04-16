package com.ekan.ekan.beneficiario.application.service;

import com.ekan.ekan.beneficiario.application.api.BeneficiarioListResponse;
import com.ekan.ekan.beneficiario.application.api.BeneficiarioRequest;
import com.ekan.ekan.beneficiario.application.api.BeneficiarioResponse;
import com.ekan.ekan.beneficiario.application.repository.BeneficiarioRepository;
import com.ekan.ekan.beneficiario.domain.Beneficiario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    @Override
    public List<BeneficiarioListResponse> listaTodosBeneficiario() {
        List<Beneficiario> beneficiarios = beneficiarioRepository.listaTodosBeneficiarios();
        return BeneficiarioListResponse.converte(beneficiarios);
    }

    @Override
    public void deletaBeneficiario(UUID idBeneficiario) {
        log.info("[inicia] BeneficiarioApplicatioService - deletaBeneficiario");
        beneficiarioRepository.deletaBeneficiario(idBeneficiario);
        log.info("[finaliza] BeneficiarioApplicatioService - deletaBeneficiario");

    }
}
