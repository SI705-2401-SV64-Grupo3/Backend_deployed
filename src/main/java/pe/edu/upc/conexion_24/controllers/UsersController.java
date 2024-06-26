package pe.edu.upc.conexion_24.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.conexion_24.dtos.PreferenceDTO;
import pe.edu.upc.conexion_24.dtos.PreferenceDTO;
import pe.edu.upc.conexion_24.dtos.UsersDTO;
import pe.edu.upc.conexion_24.entities.Users;
import pe.edu.upc.conexion_24.servicesinterfaces.UsersService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {
    @Autowired
    private UsersService uS;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public void insertar(@RequestBody UsersDTO usDTO){
        ModelMapper m = new ModelMapper();
        Users u = m.map(usDTO, Users.class);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        uS.insert(u);
    }

    @GetMapping
    public List<UsersDTO> lista(){
        return uS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,UsersDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id){
        uS.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody UsersDTO udto) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(udto, Users.class);
        uS.insert(u);
    }

    @GetMapping("/{id}")
    public UsersDTO listarId(@PathVariable("id") Long id){
        ModelMapper m = new ModelMapper();
        UsersDTO udto = m.map(uS.listId(id), UsersDTO.class);
        return udto;
    }/**
     @GetMapping("/fechanacimiento")
     public List<UsersDTO> buscarfecha(@PathVariable LocalDate fecha){
     return uS.findByBirthDate(fecha).stream().map(x->{
     ModelMapper m = new ModelMapper();
     return m.map(x, UsersDTO.class);
     }).collect(Collectors.toList());
     }
    @GetMapping("/genero")
    public List<UsersDTO> buscargenero(@RequestParam String Genero) {
        return uS.findByGenero(Genero).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, UsersDTO.class);
        }).collect(Collectors.toList());
    }*/

    @GetMapping("/genero")
    public List<Users> usersbygenero(@RequestParam String genero){
        return uS.getUsersByGenero(genero);
    }

    @GetMapping("/preferencias")
    public List<PreferenceDTO> preferencias() {
        List<String[]> results = uS.getByPreference();
        List<PreferenceDTO> preferenceDTOs = results.stream()
                .map(result -> {
                    PreferenceDTO dto = new PreferenceDTO();
                    dto.setName((String) result[0]);
                    dto.setPreference((String) result[1]);
                    return dto;
                }).collect(Collectors.toList());
        return preferenceDTOs;
    }

    @GetMapping("/check-username")
    public ResponseEntity<?> checkUsernameAvailability(@RequestParam("username") String username) {
        boolean isUsernameTaken = uS.existsByUsername(username);
        return ResponseEntity.ok().body(isUsernameTaken);
    }
}
