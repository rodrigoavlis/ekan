package com.ekan.ekan.beneficiario.domain;

import com.ekan.ekan.beneficiario.application.api.BeneficiarioAAlteracaoRequest;
import com.ekan.ekan.beneficiario.application.api.BeneficiarioRequest;
import com.ekan.ekan.documento.domain.Documento;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "Beneficiario")
@Getter
public class Beneficiario {
    @Id
    private UUID idBeneficiario;
    @NotBlank
    private String nome;
    private String telefone;
    private Sexo sexo;
    private LocalDate dataDeNascimento;
    private LocalDateTime dataInclusao;
    private LocalDateTime dataAtualizacao;
    private ArrayList<Documento> documento = new ArrayList<>();

    public Beneficiario(BeneficiarioRequest beneficiarioRequest) {
        this.idBeneficiario = UUID.randomUUID();
        this.nome = beneficiarioRequest.getNome();
        this.telefone = beneficiarioRequest.getTelefone();
        this.sexo = beneficiarioRequest.getSexo();
        this.dataDeNascimento = beneficiarioRequest.getDataDeNascimento();
        this.documento.add(new Documento(beneficiarioRequest.getDocumentoRequest()));
        this.dataInclusao = LocalDateTime.now();
    }

    public void atualiza(BeneficiarioAAlteracaoRequest beneficiarioAAlteracaoRequest) {
        if(beneficiarioAAlteracaoRequest.getNome() != null) {
            this.nome = beneficiarioAAlteracaoRequest.getNome();
        }
        if(beneficiarioAAlteracaoRequest.getTelefone() != null) {
            this.telefone = beneficiarioAAlteracaoRequest.getTelefone();
        }
        if(beneficiarioAAlteracaoRequest.getSexo() != null) {
            this.sexo = beneficiarioAAlteracaoRequest.getSexo();
        }
        if(beneficiarioAAlteracaoRequest.getDataDeNascimento() != null) {
            this.dataDeNascimento = beneficiarioAAlteracaoRequest.getDataDeNascimento();
        }
        if(beneficiarioAAlteracaoRequest.getDocumentoRequest() != null) {
            this.documento.add(new Documento(beneficiarioAAlteracaoRequest.getDocumentoRequest()));
        }

        this.dataAtualizacao = LocalDateTime.now();
    }
}
