package com.ekan.ekan.domain;

import com.ekan.ekan.application.api.BeneficiarioRequest;
import lombok.AccessLevel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "pessoas")
@Getter
public class Beneficiario {

    @Id
    private UUID idBeneficiario;
    @NotBlank
    private String nome;
    private String telefone;
    private Sexo sexo;
    private Documento documento;

    private LocalDateTime dataInclusao;
    private LocalDateTime dataAtualizacao;

    public Beneficiario(BeneficiarioRequest beneficiarioRequest) {
        this.idBeneficiario = UUID.randomUUID();
        this.nome = beneficiarioRequest.getNome();
        this.telefone = beneficiarioRequest.getTelefone();
        this.sexo = beneficiarioRequest.getSexo();
        this.documento = new Documento(beneficiarioRequest.getDocumento());
        this.dataInclusao = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }
}
