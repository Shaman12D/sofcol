package co.com.softcol.softcol.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.softcol.softcol.model.administradorModel;
import co.com.softcol.softcol.service.AdministradorService;

@RestController
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping(path = "/administrador")

public class AdministradorController {
    @Autowired
    AdministradorService adminService;

    @GetMapping()
    public @ResponseBody Iterable<administradorModel> getAll() {
        return adminService.getAdmins();
    }

    @GetMapping(path = "/{id}")
    public Optional<administradorModel> getAdminById(@PathVariable("id") int id){
        return adminService.getAdminById(id);
    }

    @PostMapping()
    public administradorModel saveAdmin(@RequestBody administradorModel admin){
        return adminService.saveAdmin(admin);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteAdminById(@PathVariable("id") int id){
        boolean ok = adminService.deleteAdminById(id);
        if (ok) return "eliminado";
        else return "no eliminado";
    }
}
