package co.com.softcol.softcol.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.softcol.softcol.model.medicoModel;
import co.com.softcol.softcol.service.MedicoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping(path = "/medico")
public class MedicoController {
    @Autowired
    MedicoService medicoService;

    @GetMapping()
    public @ResponseBody Iterable<medicoModel> getAll(){
        return medicoService.getMedicos();
    }

    @GetMapping(path = "/{id}")
    public Optional<medicoModel> getMedicoById(@PathVariable("id") int id){
        return medicoService.getMedicoById(id);
    }

    @PostMapping()
    public medicoModel saveMedico(@RequestBody medicoModel medico) {
        return medicoService.saveMedico(medico);
    }
}
