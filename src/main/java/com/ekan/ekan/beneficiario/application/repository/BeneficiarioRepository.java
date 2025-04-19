package com.ekan.ekan.beneficiario.application.repository;

import com.ekan.ekan.beneficiario.domain.Beneficiario;

import java.util.List;
import java.util.UUID;

public interface BeneficiarioRepository {

    Beneficiario salva(Beneficiario beneficiario);
    List<Beneficiario> listaTodosBeneficiarios();
    void deletaBeneficiario(UUID idBeneficiario);
    Beneficiario buscaBeneficiarioPorId(UUID idBeneficiario);
}
