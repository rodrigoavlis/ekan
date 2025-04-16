package com.ekan.ekan.beneficiario.application.api;

import com.ekan.ekan.beneficiario.domain.Beneficiario;
import com.ekan.ekan.beneficiario.domain.Sexo;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class BeneficiarioListResponse {

    private String nome;
    private String telefone;
    private Sexo sexo;
    private LocalDate dataDeNascimento;
    public static List<BeneficiarioListResponse> converte(List<Beneficiario> beneficiarios) {
        return beneficiarios.stream()
                .map(BeneficiarioListResponse::new)
                .collect(Collectors.toList());

    }
    public BeneficiarioListResponse(Beneficiario beneficiario) {
        this.nome = beneficiario.getNome();
        this.telefone = beneficiario.getTelefone();
        this.sexo = beneficiario.getSexo();
        this.dataDeNascimento = beneficiario.getDataDeNascimento();
    }


}
