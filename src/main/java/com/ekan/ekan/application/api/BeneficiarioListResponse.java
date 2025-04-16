package com.ekan.ekan.application.api;

import com.ekan.ekan.domain.Beneficiario;
import com.ekan.ekan.domain.Documento;
import com.ekan.ekan.domain.Sexo;
import lombok.Value;

@Value
public class BeneficiarioListResponse {

    private String nome;
    private String telefone;
    private Sexo sexo;
    private Documento documento;

    public BeneficiarioListResponse(Beneficiario beneficiario) {
        this.nome = beneficiario.getNome();
        this.telefone = beneficiario.getTelefone();
        this.sexo = beneficiario.getSexo();
        this.documento = beneficiario.getDocumento();
    }
}
