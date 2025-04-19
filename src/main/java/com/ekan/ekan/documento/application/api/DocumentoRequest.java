package com.ekan.ekan.documento.application.api;

import com.ekan.ekan.documento.domain.TipoDocumento;
import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class DocumentoRequest {
    private TipoDocumento tipoDocumento;
    private String descricao;


}
