package co.com.softcol.softcol.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.softcol.softcol.model.pacienteModel;
import co.com.softcol.softcol.repository.PacienteRepository;


@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    public Iterable<pacienteModel> getPacientes(){
        return pacienteRepository.findAll();
    }

    public Optional<pacienteModel> getPacienteById(int id){
        return pacienteRepository.findById(id);
    }

    public pacienteModel savePaciente(pacienteModel paciente){
        return pacienteRepository.save(paciente);
    }
    
}
