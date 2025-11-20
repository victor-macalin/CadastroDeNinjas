package dev.java10x.cadastroDeNinjas.Ninjas;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //    Listar todos os ninjas
    public List<NinjaModel> listarninjas() {
        return ninjaRepository.findAll();
    }

    //    listar por id
    public NinjaModel listarNinjasPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //    criar ninja
    public NinjaModel criarninja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    //    Deletar ninja
    public void deletarNinja(@PathVariable Long id) {
        ninjaRepository.deleteById(id);
    }

    //    Atualizar ninja
    public NinjaModel atualizaNinja(Long id, NinjaModel ninjanovo) {
        if (ninjaRepository.existsById(id)) {
            ninjanovo.setId(id);
            return ninjaRepository.save(ninjanovo);
        }
        return null;

    }
}
