package com.ekan.ekan.documento.application.api;

import com.ekan.ekan.documento.application.service.DocumentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class DocumentoController implements DocumentoAPI {
    private final DocumentoService documentoService;

    @Override
    public DocumentoResponse criaDocumento(UUID idBeneficiario, DocumentoRequest beneficiarioRequest) {
        log.info("[inicia] DocumentoController - criaDocumento");
        DocumentoResponse documento = documentoService.criaNovoDocumento(idBeneficiario, beneficiarioRequest);
        log.info("[finaliza] DocumentoController - criaDocumento");
        return documento;
    }

    @Override
    public List<DocumentoBeneficiarioListResponse> listaDeDocumentos(UUID idBeneficiario) {
        log.info("[inicia] DocumentoController - listaDeDocumentos");
        List<DocumentoBeneficiarioListResponse> documentosDoBeneficiario = documentoService.listaDeDocumentos(idBeneficiario);
        log.info("[finaliza] DocumentoController - listaDeDocumentos");
        return documentosDoBeneficiario;
    }

    @Override
    public void deletaDocumento(UUID idDocumento) {
        log.info("[inicia] DocumentoController - deletaDocumento");
        log.info("idDocumento: {}", idDocumento);
        documentoService.deletaDocumento(idDocumento);
        log.info("[finaliza] DocumentoController - deletaDocumento");

    }

}
