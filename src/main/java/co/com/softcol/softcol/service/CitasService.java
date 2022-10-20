package co.com.softcol.softcol.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.softcol.softcol.model.citasModel;
import co.com.softcol.softcol.repository.CitasRepository;

@Service
public class CitasService{
    @Autowired
    CitasRepository citasRepository;

    public Iterable<citasModel> getCitas(){
        return citasRepository.findAll();
    }

    public Optional<citasModel> getCitaById(int id){
        return citasRepository.findById(id);
    }

    public citasModel saveCitas(citasModel cita){
        return citasRepository.save(cita);
    }
}