package com.ekan.ekan.documento.domain;

import com.ekan.ekan.documento.application.api.DocumentoRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "beneficiario-documentos")
@Getter
public class Documento {
    @Id
    private UUID idDocumento;
    private UUID idBeneficiario;
    private TipoDocumento tipoDocumento;
    private String descricao;
    private LocalDateTime dataInclusao;
    private LocalDateTime dataAtualizacao;

    public Documento(DocumentoRequest documentoRequest , UUID idDoBeneficiario) {
        this.idDocumento = UUID.randomUUID();
        this.idBeneficiario = idDoBeneficiario;
        this.tipoDocumento = documentoRequest.getTipoDocumento();
        this.descricao = documentoRequest.getDescricao();
        this.dataInclusao = LocalDateTime.now();
    }
    public Documento(DocumentoRequest documentoRequest) {
        this.tipoDocumento = documentoRequest.getTipoDocumento();
        this.descricao = documentoRequest.getDescricao();
        this.dataInclusao = LocalDateTime.now();
    }

    public void atualiza(@Valid DocumentoRequest documentoRequest) {
        if(documentoRequest.getTipoDocumento() != null) {
            this.tipoDocumento = documentoRequest.getTipoDocumento();
        }
        if(documentoRequest.getDescricao() != null) {
            this.descricao = documentoRequest.getDescricao();
        }
        this.dataAtualizacao = LocalDateTime.now();
    }
}
