package com.ekan.ekan.beneficiario.application.api;

import com.ekan.ekan.beneficiario.application.service.BeneficiarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@Log4j2
public class BeneficiarioController implements BeneficiarioAPI {
    public final BeneficiarioService beneficiarioService;

    @Override
    public BeneficiarioResponse criaBeneficiario(BeneficiarioRequest beneficiarioRequest) {
        log.info("[inicia] BeneficiarioController - criaBeneficiario");
        BeneficiarioResponse criaBeneficiario = beneficiarioService.criaNovoBeneficiario(beneficiarioRequest);
        log.info("[finaliza] BeneficiarioController - criaBeneficiario");
        return criaBeneficiario;
    }

    @Override
    public List<BeneficiarioListResponse> listaDeBeneficiario() {
        log.info("[inicia] BeneficiarioController - listaDeBeneficiario");
        List<BeneficiarioListResponse> beneficiarios = beneficiarioService.listaTodosBeneficiario();
        log.info("[finaliza] BeneficiarioController - listaDeBeneficiario");
        return beneficiarios;
    }

    @Override
    public void deletaBeneficiario(UUID idBeneficiario) {
        log.info("[inicia] BeneficiarioController - deletaBeneficiario");
        log.info("idBeneficiario: {}", idBeneficiario);
        beneficiarioService.deletaBeneficiario(idBeneficiario);
        log.info("[finaliza] BeneficiarioController - deletaBeneficiario");

    }


}
