package com.ekan.ekan.application.api;

import com.ekan.ekan.application.service.BeneficiarioService;
import com.ekan.ekan.domain.Beneficiario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
