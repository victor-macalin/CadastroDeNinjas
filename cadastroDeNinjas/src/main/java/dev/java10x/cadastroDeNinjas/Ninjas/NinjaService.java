package dev.java10x.cadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

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

}
