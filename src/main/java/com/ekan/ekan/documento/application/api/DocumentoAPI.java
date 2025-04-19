package com.ekan.ekan.documento.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/public/beneficiario")
public interface DocumentoAPI {
    @PostMapping("/documento/cria/{idBeneficiario}")
    @ResponseStatus(value = HttpStatus.CREATED)
    DocumentoResponse criaDocumento( @PathVariable UUID idBeneficiario , @Valid @RequestBody DocumentoRequest beneficiarioRequest);

    @GetMapping("/documento/lista/{idBeneficiario}")
    @ResponseStatus(value = HttpStatus.OK)
    List<DocumentoBeneficiarioListResponse> listaDeDocumentos(@PathVariable UUID idBeneficiario);

    @DeleteMapping("/documento/deleta/{idDocumento}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void deletaDocumento(@PathVariable(value = "idDocumento") UUID idDocumento);
}
