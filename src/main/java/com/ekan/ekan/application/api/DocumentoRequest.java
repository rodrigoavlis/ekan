package com.ekan.ekan.application.api;

import com.ekan.ekan.domain.TipoDocumento;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class DocumentoRequest {
    private TipoDocumento tipoDocumento;
    private String descricao;
    private LocalDateTime dataInclusao;
    private LocalDateTime dataAtualizacao;
}
