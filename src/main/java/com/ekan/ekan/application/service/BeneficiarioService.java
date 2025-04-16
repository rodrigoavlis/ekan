package com.ekan.ekan.application.service;

import com.ekan.ekan.application.api.BeneficiarioListResponse;
import com.ekan.ekan.application.api.BeneficiarioRequest;
import com.ekan.ekan.application.api.BeneficiarioResponse;

import java.util.List;

public interface BeneficiarioService {

    BeneficiarioResponse criaNovoBeneficiario(BeneficiarioRequest beneficiarioRequest);
    List<BeneficiarioListResponse> listaTodosBeneficiario();
}
