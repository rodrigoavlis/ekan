package com.ekan.ekan.application.service;

import com.ekan.ekan.application.api.BeneficiarioRequest;
import com.ekan.ekan.application.api.BeneficiarioResponse;

public interface BeneficiarioService {
    BeneficiarioResponse criaNovoBeneficiario(BeneficiarioRequest beneficiarioRequest);
}
