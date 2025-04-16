package com.ekan.ekan.application.repository;

import com.ekan.ekan.domain.Beneficiario;

import java.util.List;

public interface BeneficiarioRepository {

    Beneficiario salva(Beneficiario beneficiario);
    List<Beneficiario> listaTodosBeneficiarios();
}
