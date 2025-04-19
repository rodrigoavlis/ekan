package com.ekan.ekan.documento.application.api;

import com.ekan.ekan.documento.domain.Documento;
import com.ekan.ekan.documento.domain.TipoDocumento;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class DocumentoBeneficiarioListResponse {
    private UUID idDocumento;
    private String descricao;
    private TipoDocumento tipoDocumento;
    private LocalDateTime dataInclusao;

    public static List<DocumentoBeneficiarioListResponse> converte(List<Documento> documentosDoBeneficiario) {
        return documentosDoBeneficiario.stream()
                .map(DocumentoBeneficiarioListResponse::new)
                .collect(Collectors.toList());
    }
    public DocumentoBeneficiarioListResponse(Documento documento) {
        this.idDocumento = documento.getIdDocumento();
        this.descricao = documento.getDescricao();
        this.tipoDocumento = documento.getTipoDocumento();
        this.dataInclusao = documento.getDataInclusao();
    }


    }




