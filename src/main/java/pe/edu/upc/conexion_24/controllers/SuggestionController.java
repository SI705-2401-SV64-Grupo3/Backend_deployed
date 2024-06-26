package pe.edu.upc.conexion_24.controllers;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.conexion_24.dtos.ConversationDTO;
import pe.edu.upc.conexion_24.dtos.SuggestionDTO;
import pe.edu.upc.conexion_24.entities.Conversation;
import pe.edu.upc.conexion_24.entities.Suggestion;
import pe.edu.upc.conexion_24.entities.Users;
import pe.edu.upc.conexion_24.servicesinterfaces.SuggestionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sugerencias")
@CrossOrigin(origins = "http://localhost:4200")
public class SuggestionController {
    @Autowired
    private SuggestionService sS;

    @GetMapping
    public List<SuggestionDTO> lista(){
        return sS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,SuggestionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void registrar(@RequestBody SuggestionDTO dto) {
        ModelMapper m = new ModelMapper();
        Suggestion s = m.map(dto, Suggestion.class);
        sS.insert(s);
    }

}
