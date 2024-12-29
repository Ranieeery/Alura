package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.dto.SolicitacaoAprovarDTO;
import br.com.alura.adopet.api.dto.SolicitacaoReprovarDTO;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.api.validations.ValidacaoSolicitacaoAdocao;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AdocaoService {

    private final AdocaoRepository repository;

    private final PetRepository petRepository;

    private final TutorRepository tutorRepository;

    private final EmailService emailService;

    private final List<ValidacaoSolicitacaoAdocao> validacoes;

    public AdocaoService(AdocaoRepository repository, PetRepository petRepository, TutorRepository tutorRepository, EmailService emailService, List<ValidacaoSolicitacaoAdocao> validacoes) {
        this.repository = repository;
        this.petRepository = petRepository;
        this.tutorRepository = tutorRepository;
        this.emailService = emailService;
        this.validacoes = validacoes;
    }

    public void solicitar(SolicitacaoAdocaoDTO dto) {
        Pet pet = petRepository.getReferenceById(dto.idPet());
        Tutor tutor = tutorRepository.getReferenceById(dto.idTutor());

        validacoes.forEach(v -> v.validar(dto));

        Adocao adocao = new Adocao(pet, tutor, dto.motivo());
        repository.save(adocao);

        emailService.enviarEmail(adocao.getPet().getAbrigo().getEmail(), "Solicitação de adoção", "Olá " + adocao.getPet().getAbrigo().getNome() + "!\n\nUma solicitação de adoção foi registrada hoje para o pet: " + adocao.getPet().getNome() + ". \nFavor avaliar para aprovação ou reprovação.");
    }

    public void aprovar(SolicitacaoAprovarDTO dto) {
        Adocao adocao = repository.getReferenceById(dto.idAdocao());

        adocao.aprovar();

        emailService.enviarEmail(adocao.getTutor().getEmail(), "Adoção aprovada", "Parabéns " + adocao.getTutor().getNome() + "!\n\nSua adoção do pet " + adocao.getPet().getNome() + ", solicitada em " + adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }

    public void reprovar(SolicitacaoReprovarDTO dto) {
        Adocao adocao = repository.getReferenceById(dto.idAdocao());

        adocao.reprovar(dto.justificativa());

        emailService.enviarEmail(adocao.getTutor().getEmail(), "Adoção reprovada", "Olá " + adocao.getTutor().getNome() + "!\n\nInfelizmente sua adoção do pet " + adocao.getPet().getNome() + ", solicitada em " + adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + ", foi reprovada pelo abrigo " + adocao.getPet().getAbrigo().getNome() + " com a seguinte justificativa: " + adocao.getJustificativaStatus());
    }
}
