package com.ekan.ekan.documento.application.service;

import com.ekan.ekan.documento.application.api.DocumentoBeneficiarioListResponse;
import com.ekan.ekan.documento.application.api.DocumentoRequest;
import com.ekan.ekan.documento.application.api.DocumentoResponse;
import com.ekan.ekan.documento.application.repository.DocumentoRepository;
import com.ekan.ekan.documento.domain.Documento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class DocumentoApplicationService implements DocumentoService {
    private final DocumentoRepository documentoRepository;

    @Override
    public DocumentoResponse criaNovoDocumento(UUID idBeneficiario, DocumentoRequest beneficiarioRequest) {
        log.info("[inicia] DocumentoApplicationService - criaNovoDocumento");
        log.info("idBeneficiario: {}", idBeneficiario);
        Documento documento = documentoRepository.salva(new Documento(beneficiarioRequest, idBeneficiario));
        log.info("[finaliza] DocumentoApplicationService - criaNovoDocumento");
        return new DocumentoResponse(documento);
    }

    @Override
    public List<DocumentoBeneficiarioListResponse> listaDeDocumentos(UUID idBeneficiario) {
        log.info("[inicia] DocumentoApplicationService - listaDeDocumentos");
        log.info("idBeneficiario: {}", idBeneficiario);
        List<Documento> documentosDoBeneficiario = documentoRepository.listaDeDocumentos(idBeneficiario);
        log.info("[finaliza] DocumentoApplicationService - listaDeDocumentos");
        return DocumentoBeneficiarioListResponse.converte(documentosDoBeneficiario);
    }

    @Override
    public void deletaDocumento(UUID idDocumento) {
        log.info("[inicia] DocumentoApplicationService - deletaDocumento");
        log.info("idDocumento: {}", idDocumento);
        Documento documento = documentoRepository.buscaDocumentoPorId(idDocumento);
        documentoRepository.deletaDocumento(documento);
        log.info("[finaliza] DocumentoApplicationService - deletaDocumento");

    }

}
