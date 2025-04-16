package com.ekan.ekan.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Documento {

    private UUID idDocumento;
    private TipoDocumento tipoDocumento;
    private String descricao;
    private LocalDateTime dataInclusao;
    private LocalDateTime dataAtualizacao;

    public Documento(Documento documentoRequest) {
        this.idDocumento = UUID.randomUUID();
        this.tipoDocumento = documentoRequest.getTipoDocumento();
        this.descricao = documentoRequest.getDescricao();
        this.dataInclusao = documentoRequest.getDataInclusao();
        this.dataAtualizacao = documentoRequest.getDataAtualizacao();
    }
}
