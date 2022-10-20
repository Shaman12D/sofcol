package co.com.softcol.softcol.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.softcol.softcol.model.administradorModel;
import co.com.softcol.softcol.repository.AdministradorRepository;

@Service
public class AdministradorService {
    @Autowired
    AdministradorRepository adminRepository;

    public Iterable<administradorModel> getAdmins(){
        return adminRepository.findAll();
    }

    public Optional<administradorModel> getAdminById(int id){
        return adminRepository.findById(id);
    }

    public administradorModel saveAdmin(administradorModel admin){
        return adminRepository.save(admin);
    }

    public boolean deleteAdminById(int id){
        try {
            adminRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
