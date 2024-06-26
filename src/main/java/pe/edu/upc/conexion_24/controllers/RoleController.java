package pe.edu.upc.conexion_24.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.conexion_24.dtos.RoleDTO;
import pe.edu.upc.conexion_24.dtos.UsersDTO;
import pe.edu.upc.conexion_24.entities.Role;
import pe.edu.upc.conexion_24.entities.Users;
import pe.edu.upc.conexion_24.servicesinterfaces.RoleService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "http://localhost:4200")
public class RoleController {
    @Autowired
    private RoleService rS;

    @PostMapping
    public void registrar(@RequestBody RoleDTO dto) {
        ModelMapper m = new ModelMapper();
        Role r = m.map(dto, Role.class);
        rS.insert(r);
    }



    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        rS.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody RoleDTO rdto) {
        ModelMapper m = new ModelMapper();
        Role r= m.map(rdto, Role.class);
        rS.insert(r);
    }


    @GetMapping("/{id}")
    public RoleDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        RoleDTO dto = m.map(rS.listId(id), RoleDTO.class);
        return dto;
    }

    @GetMapping
    public List<RoleDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RoleDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/rol")
    public List<Role> usersbyrol(@RequestParam String rol){
        return rS.getRoleByRol(rol);
    }



}
