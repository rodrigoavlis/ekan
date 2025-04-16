package com.ekan.ekan.beneficiario.application.api;

import com.ekan.ekan.beneficiario.domain.Beneficiario;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class BeneficiarioDetalhadoResponse {
    private Documento documento;
    private LocalDateTime dataAtualizacao;

    public BeneficiarioDetalhadoResponse(Beneficiario beneficiario) {
        this.documento = beneficiario.getDocumento();
        this.dataAtualizacao = LocalDateTime.now();
    }
}
