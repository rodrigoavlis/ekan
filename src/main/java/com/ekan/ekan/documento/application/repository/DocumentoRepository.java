package com.ekan.ekan.documento.application.repository;

import com.ekan.ekan.documento.application.api.DocumentoResponse;
import com.ekan.ekan.documento.domain.Documento;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public interface DocumentoRepository {

    Documento salva(Documento documento);
    List<Documento> listaDeDocumentos(UUID idBeneficiario);
    void save(Documento documento);
    Documento buscaDocumentoPorId(@NotNull(message = "idDocumento não pode ser nulo") UUID idDocumento);
    void deletaDocumento(Documento documento);
    void deletaPorIdBeneficiario(UUID idBeneficiario);
}
