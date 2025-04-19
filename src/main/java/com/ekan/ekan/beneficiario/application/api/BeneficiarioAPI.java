package com.ekan.ekan.beneficiario.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/public/beneficiario")
public interface BeneficiarioAPI {

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    BeneficiarioResponse criaBeneficiario(@RequestBody @Valid BeneficiarioRequest beneficiarioRequest);

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    List<BeneficiarioListResponse> listaDeBeneficiario();

    @DeleteMapping(value = "/deleta/{idBeneficiario}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void deletaBeneficiario(@PathVariable(value = "idBeneficiario") UUID idBeneficiario);

    @PatchMapping(value = "/altera/{idBeneficiario}")
    @ResponseStatus(value = HttpStatus.OK)
    void alteraBeneficiario(@PathVariable UUID idBeneficiario,
                                                     @RequestBody @Valid BeneficiarioAAlteracaoRequest beneficiarioAAlteracaoRequest);


}
