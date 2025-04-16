package com.ekan.ekan.application.api;

import com.ekan.ekan.domain.Documento;
import com.ekan.ekan.domain.Sexo;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class BeneficiarioRequest {
    @NotBlank
    private String nome;
    private String telefone;
    private Sexo sexo;
    private Documento documento;
}
