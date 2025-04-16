package com.ekan.ekan.beneficiario.application.api;

import com.ekan.ekan.beneficiario.domain.Beneficiario;
import lombok.Getter;

import java.util.UUID;


@Getter
public class BeneficiarioResponse {
    private UUID idBeneficiario;

    public BeneficiarioResponse(Beneficiario beneficiario) {
        this.idBeneficiario = beneficiario.getIdBeneficiario();
    }
}
