package pe.edu.upc.conexion_24.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.conexion_24.dtos.MessageDTO;
import pe.edu.upc.conexion_24.dtos.SuggestionDTO;
import pe.edu.upc.conexion_24.entities.Message;
import pe.edu.upc.conexion_24.entities.Suggestion;
import pe.edu.upc.conexion_24.servicesinterfaces.MessageService;
import pe.edu.upc.conexion_24.servicesinterfaces.SuggestionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mensajes")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {
    @Autowired
    private MessageService mS;

    @GetMapping
    public List<MessageDTO> lista(){
        return mS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,MessageDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody MessageDTO dto) {
        ModelMapper m = new ModelMapper();
        Message sms = m.map(dto, Message.class);
        mS.insert(sms);
    }
    @GetMapping("/conversacion/{conversationId}")
    public List<MessageDTO> listByConversationId(@PathVariable Long conversationId) {
        return mS.listByConversationId(conversationId).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MessageDTO.class);
        }).collect(Collectors.toList());
    }
}
