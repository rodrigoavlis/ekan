package com.ekan.ekan.beneficiario.application.service;

import com.ekan.ekan.beneficiario.application.api.BeneficiarioAAlteracaoRequest;
import com.ekan.ekan.beneficiario.application.api.BeneficiarioListResponse;
import com.ekan.ekan.beneficiario.application.api.BeneficiarioRequest;
import com.ekan.ekan.beneficiario.application.api.BeneficiarioResponse;
import com.ekan.ekan.beneficiario.application.repository.BeneficiarioRepository;
import com.ekan.ekan.beneficiario.domain.Beneficiario;
import com.ekan.ekan.documento.application.repository.DocumentoRepository;
import com.ekan.ekan.documento.domain.Documento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class BeneficiarioApplicatioService implements BeneficiarioService {
    public final BeneficiarioRepository beneficiarioRepository;
    public final DocumentoRepository documentoRepository;

    @Override
    public BeneficiarioResponse criaNovoBeneficiario(BeneficiarioRequest beneficiarioRequest) {
        log.info("[inicia] BeneficiarioApplicatioService - criaNovoBeneficiario");
        Beneficiario beneficiario = beneficiarioRepository.salva(new Beneficiario(beneficiarioRequest));
        Documento documento = new Documento(beneficiarioRequest.getDocumentoRequest(), beneficiario.getIdBeneficiario());
        documentoRepository.save(documento);
        log.info("[finaliza] BeneficiarioApplicatioService - criaNovoBeneficiario");
        return new BeneficiarioResponse(beneficiario);
    }

    @Override
    public List<BeneficiarioListResponse> listaTodosBeneficiario() {
        log.info("[inicia] BeneficiarioApplicatioService - listaTodosBeneficiario");
        List<Beneficiario> beneficiarios = beneficiarioRepository.listaTodosBeneficiarios();
        log.info("[finaliza] BeneficiarioApplicatioService - listaTodosBeneficiario");
        return BeneficiarioListResponse.converte(beneficiarios);
    }

    @Override
    public void deletaBeneficiario(UUID idBeneficiario) {
        log.info("[inicia] BeneficiarioApplicatioService - deletaBeneficiario");
        documentoRepository.deletaPorIdBeneficiario(idBeneficiario);
        beneficiarioRepository.deletaBeneficiario(idBeneficiario);
        log.info("[finaliza] BeneficiarioApplicatioService - deletaBeneficiario");
    }

    @Override
    public void alteraBeneficiario(UUID idBeneficiario, BeneficiarioAAlteracaoRequest beneficiarioAAlteracaoRequest) {
        log.info("[inicia] BeneficiarioApplicatioService - alteraBeneficiario");
        Beneficiario beneficiario = beneficiarioRepository.buscaBeneficiarioPorId(idBeneficiario);
        beneficiario.atualiza(beneficiarioAAlteracaoRequest);
        beneficiarioRepository.salva(beneficiario);
        Documento documento = documentoRepository.buscaDocumentoPorId(beneficiarioAAlteracaoRequest.getIdDocumento());
        documento.atualiza(beneficiarioAAlteracaoRequest.getDocumentoRequest());
        documentoRepository.save(documento);
        log.info("[finaliza] BeneficiarioApplicatioService - alteraBeneficiario");


    }
}
