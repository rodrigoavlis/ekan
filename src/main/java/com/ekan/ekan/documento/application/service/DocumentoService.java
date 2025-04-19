package com.ekan.ekan.documento.application.service;

import com.ekan.ekan.documento.application.api.DocumentoBeneficiarioListResponse;
import com.ekan.ekan.documento.application.api.DocumentoRequest;
import com.ekan.ekan.documento.application.api.DocumentoResponse;

import java.util.List;
import java.util.UUID;

public interface DocumentoService {

    DocumentoResponse criaNovoDocumento(UUID idBeneficiario, DocumentoRequest beneficiarioRequest);
    List<DocumentoBeneficiarioListResponse> listaDeDocumentos(UUID idBeneficiario);
    void deletaDocumento(UUID idDocumento);
}
