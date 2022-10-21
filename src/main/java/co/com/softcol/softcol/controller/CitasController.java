package co.com.softcol.softcol.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.softcol.softcol.model.citasModel;
import co.com.softcol.softcol.service.CitasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CitasController {
    @Autowired
    CitasService citasService;

    @GetMapping()
    public @ResponseBody Iterable<citasModel> getAll() {
        return citasService.getCitas();
    }

    @GetMapping(value="/{id}")
    public Optional<citasModel> getCitaById(@RequestParam("id") int id) {
        return citasService.getCitaById(id);
    }

    @PostMapping()
    public citasModel saveCita(@RequestBody citasModel cita) {
        return citasService.saveCitas(cita);
    }
}
