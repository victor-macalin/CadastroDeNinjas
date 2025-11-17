package dev.java10x.cadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> 9b57f9800ddd51285e7e701da1515a9cfe9b6bd7

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
//    Listar todos os ninjas
    public List<NinjaModel> listarninjas (){
        return ninjaRepository.findAll();
    }
//    listar por id
<<<<<<< HEAD
public NinjaModel listarNinjasPorId (Long id) {
    Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
    return ninjaPorId.orElse(null);
}
=======

>>>>>>> 9b57f9800ddd51285e7e701da1515a9cfe9b6bd7
}
