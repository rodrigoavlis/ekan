package com.ekan.ekan.beneficiario.application.api;

import com.ekan.ekan.beneficiario.domain.Sexo;
import com.ekan.ekan.documento.application.api.DocumentoRequest;
import lombok.Getter;
import lombok.Value;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
@Getter
public class BeneficiarioRequest {
    @NotBlank
    private String nome;
    private String telefone;
    private Sexo sexo;
    @NotNull
    private LocalDate dataDeNascimento;
    private DocumentoRequest documentoRequest;
}


