package com.ekan.ekan.beneficiario.application.api;

import com.ekan.ekan.beneficiario.domain.Sexo;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Value
public class BeneficiarioRequest {
    @NotBlank
    private String nome;
    private String telefone;
    private Sexo sexo;
    private LocalDate dataDeNascimento;
}
