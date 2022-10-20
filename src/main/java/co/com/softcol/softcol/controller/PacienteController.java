package co.com.softcol.softcol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.softcol.softcol.model.pacienteModel;
import co.com.softcol.softcol.service.PacienteService;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping(path = "/paciente")

public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @GetMapping()
    public @ResponseBody Iterable<pacienteModel> getAll() {
        return pacienteService.getPacientes();
    }

    @PostMapping()
    public pacienteModel savePaciente(@RequestBody pacienteModel paciente) {
        return pacienteService.savePaciente(paciente);
    }
    
    
}
