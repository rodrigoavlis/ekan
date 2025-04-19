package com.ekan.ekan.beneficiario.application.api;

import com.ekan.ekan.beneficiario.domain.Sexo;
import com.ekan.ekan.documento.application.api.DocumentoRequest;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Value
public class BeneficiarioAAlteracaoRequest {

    private String nome;
    private String telefone;
    private Sexo sexo;
    private LocalDate dataDeNascimento;
    @NotNull(message = "idDocumento não pode ser nulo")
    private UUID idDocumento;
    @Valid
    private DocumentoRequest documentoRequest;
}
