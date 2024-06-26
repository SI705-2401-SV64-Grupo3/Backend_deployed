package pe.edu.upc.conexion_24.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.conexion_24.dtos.CommentDTO;
import pe.edu.upc.conexion_24.dtos.ConversationDTO;
import pe.edu.upc.conexion_24.entities.Comment;
import pe.edu.upc.conexion_24.entities.Conversation;
import pe.edu.upc.conexion_24.servicesinterfaces.CommentService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/comentarios")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {
    @Autowired
    private CommentService cS;
    @GetMapping
    public List<CommentDTO> lista(){
        return cS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,CommentDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void registrar(@RequestBody CommentDTO dto) {
        ModelMapper m = new ModelMapper();
        Comment c = m.map(dto, Comment.class);
        cS.insert(c);
    }
}
