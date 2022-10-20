package co.com.softcol.softcol.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.softcol.softcol.model.medicoModel;
import co.com.softcol.softcol.repository.MedicoRepository;

@Service
public class MedicoService {
    @Autowired
    MedicoRepository medicoRepository;

    public Iterable<medicoModel> getMedicos() {
        return medicoRepository.findAll();
    }

    public Optional<medicoModel> getMedicoById(int id) {
        return medicoRepository.findById(id);
    }

    public medicoModel saveMedico(medicoModel medico) {
        return medicoRepository.save(medico);
    }

    public boolean deleteMedicoById(int id){
        try {
            medicoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
