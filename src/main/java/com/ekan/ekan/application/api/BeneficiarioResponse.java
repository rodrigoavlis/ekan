package com.ekan.ekan.application.api;

import com.ekan.ekan.domain.Beneficiario;
import lombok.Getter;

import java.util.UUID;


@Getter
public class BeneficiarioResponse {
    private UUID idBeneficiario;

    public BeneficiarioResponse(Beneficiario beneficiario) {
        this.idBeneficiario = beneficiario.getIdBeneficiario();
    }
}
