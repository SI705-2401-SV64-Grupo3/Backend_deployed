package pe.edu.upc.conexion_24.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.conexion_24.dtos.*;
import pe.edu.upc.conexion_24.entities.Goals;
import pe.edu.upc.conexion_24.entities.Publication;
import pe.edu.upc.conexion_24.servicesinterfaces.GoalsService;
import pe.edu.upc.conexion_24.servicesinterfaces.PublicationService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/metas")
@CrossOrigin(origins = "http://localhost:4200")
public class GoalsController {
    @Autowired
    private GoalsService gS;

    @GetMapping
    public List<GoalsDTO> lista(){
        return gS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,GoalsDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody GoalsDTO dto) {
        ModelMapper m = new ModelMapper();
        Goals g = m.map(dto, Goals.class);
        gS.insert(g);
    }

    @PutMapping
    public void modificar(@RequestBody GoalsDTO gdto) {
        ModelMapper m = new ModelMapper();
        Goals g= m.map(gdto, Goals.class);
        gS.insert(g);
    }
    @GetMapping("/{id}")
    public GoalsDTO listarId(@PathVariable("id") Long userid) {
        List<Goals> goals = gS.findByUserId(userid);
        ModelMapper m = new ModelMapper();
        GoalsDTO gdto = m.map(goals, GoalsDTO.class);
        return gdto;
    }
    /***
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        gS.delete(id);
    }



    @GetMapping("/metasporusuario")
    public List<GoalUserDTO> cantidadmetas(@Param("nombre") String nombre){
        return gS.countGoalsByName().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, GoalUserDTO.class);
        }).collect(Collectors.toList());

    }*/

    @GetMapping("/metasporusuario")
    @PreAuthorize("hasAnyAuthority('ADMIN')")

    public List<GoalUserDTO> cantidadmetas(@Param("nombre") String nombre) {
        return gS.countGoalsByName(nombre).stream().map(y -> {
            GoalUserDTO dto = new GoalUserDTO();
            dto.setName(y[0]);
            dto.setQuantityGoals(Long.valueOf(y[1]));
            return dto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/metasLogradas")
    public GoalsSuccededDTO metasLogradas(@Param("id") Long id){
        List<String[]> result = gS.goalsSucceded(id); // Supongo que esto devuelve una lista de arrays de strings

        if (result != null && !result.isEmpty()) {
            String[] firstItem = result.get(0); // Obtenemos el primer array de strings

            GoalsSuccededDTO dto = new GoalsSuccededDTO();
            dto.setUserName(firstItem[0]);
            dto.setQuantityGoals(Long.valueOf(firstItem[1]));
            return dto;
        } else {
            // Manejo de caso donde no se encontraron resultados o la lista está vacía
            throw new RuntimeException("No se encontraron metas logradas para el ID proporcionado");
        }
    }

}
