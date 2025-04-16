package com.ekan.ekan.application.api;

import com.ekan.ekan.application.service.BeneficiarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Log4j2
public class BeneficiarioController implements BeneficiarioAPI {
    public final BeneficiarioService beneficiarioService;

    @Override
    public BeneficiarioResponse criaBeneficiario(BeneficiarioRequest beneficiarioRequest) {
        log.info("[inicia] BeneficiarioController - criaBeneficiario");
        BeneficiarioResponse criaBeneficiario = beneficiarioService.criaNovoBeneficiario(beneficiarioRequest);
        log.info("[inicia] BeneficiarioController - criaBeneficiario");
        return criaBeneficiario;
    }
}
