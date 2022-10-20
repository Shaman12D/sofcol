package co.com.softcol.softcol.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.softcol.softcol.model.areaModel;
import co.com.softcol.softcol.repository.AreaRepository;

@Service
public class AreaService {
    @Autowired
    AreaRepository areaRepository;

    //Listar
    public Iterable<areaModel> getAreas(){
        return areaRepository.findAll();
    }

    //Listar por id
    public Optional<areaModel> getAreaById(int id){
        return areaRepository.findById(id);
    }

    public areaModel saveArea(areaModel area){
        return areaRepository.save(area);
    }

    public boolean deleteAreaById(int id){
        try {
            areaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
