package co.com.softcol.softcol.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.internal.util.collections.ArrayHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.softcol.softcol.model.pacienteModel;
import co.com.softcol.softcol.service.PacienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping(path = "/paciente")

public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @GetMapping()
    public @ResponseBody Iterable<pacienteModel> getAll() {
        return pacienteService.getPacientes();
    }

    @GetMapping(path = "/{id}")
    public Optional<pacienteModel> getPacienteById(@PathVariable("id") int id){
        return pacienteService.getPacienteById(id);
    }

    @PostMapping()
    public pacienteModel savePaciente(@RequestBody pacienteModel paciente) {
        return pacienteService.savePaciente(paciente);
    }
}
