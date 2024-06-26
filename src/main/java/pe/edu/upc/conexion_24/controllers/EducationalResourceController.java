package pe.edu.upc.conexion_24.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.conexion_24.dtos.EducationalResourceDTO;
import pe.edu.upc.conexion_24.dtos.GoalsDTO;
import pe.edu.upc.conexion_24.entities.EducationalResource;
import pe.edu.upc.conexion_24.entities.Goals;
import pe.edu.upc.conexion_24.servicesinterfaces.EducationalResourceService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/recursoseducativos")
@CrossOrigin(origins = "http://localhost:4200")
public class EducationalResourceController {
    @Autowired
    private EducationalResourceService erS;
    @GetMapping
    public List<EducationalResourceDTO> lista(){
        return erS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,EducationalResourceDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void registrar(@RequestBody EducationalResourceDTO dto) {
        ModelMapper m = new ModelMapper();
        EducationalResource er = m.map(dto, EducationalResource.class);
        erS.insert(er);
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody EducationalResourceDTO erdto) {
        ModelMapper m = new ModelMapper();
        EducationalResource er= m.map(erdto, EducationalResource.class);
        erS.insert(er);
    }
}
