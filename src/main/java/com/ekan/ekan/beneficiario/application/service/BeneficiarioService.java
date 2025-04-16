package com.ekan.ekan.beneficiario.application.service;

import com.ekan.ekan.beneficiario.application.api.BeneficiarioListResponse;
import com.ekan.ekan.beneficiario.application.api.BeneficiarioRequest;
import com.ekan.ekan.beneficiario.application.api.BeneficiarioResponse;

import java.util.List;
import java.util.UUID;

public interface BeneficiarioService {

    BeneficiarioResponse criaNovoBeneficiario(BeneficiarioRequest beneficiarioRequest);
    List<BeneficiarioListResponse> listaTodosBeneficiario();
    void deletaBeneficiario(UUID idBeneficiario);
}
