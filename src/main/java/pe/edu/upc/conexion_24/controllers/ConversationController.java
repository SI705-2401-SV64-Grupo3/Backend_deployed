package pe.edu.upc.conexion_24.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.conexion_24.dtos.ConversationDTO;
import pe.edu.upc.conexion_24.dtos.EducationalResourceDTO;
import pe.edu.upc.conexion_24.entities.Conversation;
import pe.edu.upc.conexion_24.entities.EducationalResource;
import pe.edu.upc.conexion_24.servicesinterfaces.ConversationService;
import pe.edu.upc.conexion_24.servicesinterfaces.EducationalResourceService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/conversacion")
@CrossOrigin(origins = "http://localhost:4200")
public class ConversationController {
    @Autowired
    private ConversationService cS;
    @GetMapping
    public List<ConversationDTO> lista(){
        return cS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,ConversationDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody ConversationDTO dto) {
        ModelMapper m = new ModelMapper();
        Conversation c = m.map(dto, Conversation.class);
        cS.insert(c);
    }
}
