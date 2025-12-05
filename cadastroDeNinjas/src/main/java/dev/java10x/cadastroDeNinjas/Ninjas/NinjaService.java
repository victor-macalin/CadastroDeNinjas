package dev.java10x.cadastroDeNinjas.Ninjas;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {


    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //    Listar todos os ninjas
    public List<NinjaDTO> listarninjas() {
        List<NinjaModel> ninjas =  ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //    listar por id
    public NinjaDTO listarNinjasPorId(Long id) {
        Optional<NinjaModel> ninjaId = ninjaRepository.findById(id);
        return ninjaId.map(ninjaMapper::map).orElse(null);
    }
    //    criar ninja
    public NinjaDTO criarninja (NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = new NinjaMapper().map(ninjaDTO);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);

    }

    //    Deletar ninja
    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }

    //    Atualizar ninja
    public NinjaDTO atualizaNinja(Long id, NinjaDTO ninjanovo) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()){
            NinjaModel ninjaModel = ninjaMapper.map(ninjanovo);
            ninjaModel.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaModel);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }
}
