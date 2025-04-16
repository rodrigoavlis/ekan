package com.ekan.ekan.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/public/beneficiario")
public interface BeneficiarioAPI {

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    BeneficiarioResponse criaBeneficiario(@RequestBody @Valid BeneficiarioRequest beneficiarioRequest);

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    List<BeneficiarioListResponse> listaDeBeneficiario();

}
