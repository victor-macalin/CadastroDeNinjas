package dev.java10x.cadastroDeNinjas.Missoes;

import org.flywaydb.core.api.MigrationInfoService;
import org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }
//    Cria uma missao
    public MissoesDTO create (MissoesDTO missao) {
        MissoesModel missaoModel = missoesMapper.map(missao);
        missaoModel = missoesRepository.save(missaoModel);
        return missoesMapper.map(missaoModel);
    }

    //    Listar todas missoes
    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //    Listar missoes por ID
    public MissoesDTO missaoPorId(Long id) {
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.map(missoesMapper::map).orElse(null);
    }

    //    Atualizar missoes
    public MissoesDTO atualizarMissoesId(Long id, MissoesDTO missoesAtualizada) {
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        if (missoesModel.isPresent()) {
            MissoesModel novaMissao = missoesMapper.map(missoesAtualizada);
            novaMissao.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(novaMissao);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }

    //    Deletar missoes
    public void delete(@PathVariable Long id) {
        missoesRepository.deleteById(id);
    }

}
