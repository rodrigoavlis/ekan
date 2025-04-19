package com.ekan.ekan.documento.application.api;


import com.ekan.ekan.documento.domain.Documento;
import lombok.Getter;
import java.util.UUID;

@Getter
public class DocumentoResponse {

    private UUID idDocumento;

    public DocumentoResponse(Documento documento) {
        this.idDocumento = documento.getIdDocumento();
    }
}
