package com.ekan.ekan.documento.infra;

import com.ekan.ekan.documento.application.api.DocumentoResponse;
import com.ekan.ekan.documento.application.repository.DocumentoRepository;
import com.ekan.ekan.documento.domain.Documento;
import com.ekan.ekan.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@EnableMongoRepositories
@Log4j2
@Repository
public class DocumentoInfraRepository implements DocumentoRepository {
    private final DocumentoSpringDataJPARepository documentoSpringDataJPARepository;
    @Override
    public Documento salva(Documento documento) {
        log.info("[inicia] DocumentoInfraRepository - salva");
        Documento novoDocumento = documentoSpringDataJPARepository.save(documento);
        log.info("[finaliza] DocumentoInfraRepository - salva");
        return novoDocumento;
    }

    @Override
    public List<Documento> listaDeDocumentos(UUID idBeneficiario) {
        log.info("[inicia] DocumentoInfraRepository - listaDeDocumentos");
        log.info("idBeneficiario: {}", idBeneficiario);
        List<Documento> documentos = documentoSpringDataJPARepository.findAllByIdBeneficiario(idBeneficiario);
        log.info("[finaliza] DocumentoInfraRepository - listaDeDocumentos");
        return documentos;
    }

    @Override
    public void save(Documento documento) {
        log.info("[inicia] DocumentoInfraRepository - save");
        documentoSpringDataJPARepository.save(documento);
        log.info("[finaliza] DocumentoInfraRepository - save");

    }

    @Override
    public Documento buscaDocumentoPorId(UUID idDocumento) {
        log.info("[inicia] DocumentoInfraRepository - buscaDocumentoPorId");
        var documento = documentoSpringDataJPARepository.findById(idDocumento)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Documento não encontrado = " + idDocumento));
        return documento;
    }

    @Override
    public void deletaDocumento(Documento documento) {
        log.info("[inicia] DocumentoInfraRepository - deletaDocumento");
        documentoSpringDataJPARepository.delete(documento);
        log.info("[finaliza] DocumentoInfraRepository - deletaDocumento");

    }

    @Override
    public void deletaPorIdBeneficiario(UUID idBeneficiario) {
        log.info("[inicia] DocumentoInfraRepository - deletaPorIdBeneficiario");
        documentoSpringDataJPARepository.deleteByIdBeneficiario(idBeneficiario);
        log.info("[finaliza] DocumentoInfraRepository - deletaPorIdBeneficiario");

    }
}
