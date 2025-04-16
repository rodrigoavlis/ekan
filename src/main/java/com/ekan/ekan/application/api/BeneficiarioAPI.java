package com.ekan.ekan.application.api;

import com.ekan.ekan.domain.Beneficiario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/public/beneficiario")
public interface BeneficiarioAPI {

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    BeneficiarioResponse criaBeneficiario(@RequestBody @Valid BeneficiarioRequest beneficiarioRequest);

}
