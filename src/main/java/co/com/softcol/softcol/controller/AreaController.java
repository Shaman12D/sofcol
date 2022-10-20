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

import co.com.softcol.softcol.model.areaModel;
import co.com.softcol.softcol.service.AreaService;

@RestController
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping(path = "/area")

public class AreaController {
    @Autowired
    AreaService areaService;

    @GetMapping()
    public @ResponseBody Iterable<areaModel> getAll(){
        return areaService.getAreas();
    }

    @GetMapping(path = "/{id}")
    public Optional<areaModel> getAreaById(@PathVariable("id") int id){
        return areaService.getAreaById(id);
    }

    @PostMapping()
    public areaModel saveArea(@RequestBody areaModel area){
        return areaService.saveArea(area);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteAreaById(@PathVariable("id") int id){
        boolean ok = areaService.deleteAreaById(id);
        if (ok) return "eliminado";
        else return "no eliminado";
    }
}
