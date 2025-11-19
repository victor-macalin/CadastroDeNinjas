package dev.java10x.cadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //    Cria uma missao

    //    Listar todas missoes
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    //    Listar missoes por ID
    public MissoesModel missaoPorId(Long id) {
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.orElse(null);
    }

//    Atualizar missoes

//    Deletar missoes

}
