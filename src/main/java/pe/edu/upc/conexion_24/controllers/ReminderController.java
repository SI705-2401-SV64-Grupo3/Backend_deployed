package pe.edu.upc.conexion_24.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.conexion_24.dtos.CommentDTO;
import pe.edu.upc.conexion_24.dtos.ReminderDTO;
import pe.edu.upc.conexion_24.entities.Comment;
import pe.edu.upc.conexion_24.entities.Reminder;
import pe.edu.upc.conexion_24.servicesinterfaces.ReminderService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/recordatorios")
@CrossOrigin(origins = "http://localhost:4200")
public class ReminderController {
    @Autowired
    private ReminderService rS;
    @GetMapping
    public List<ReminderDTO> lista(){
        return rS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,ReminderDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody ReminderDTO dto) {
        ModelMapper m = new ModelMapper();
        Reminder r = m.map(dto, Reminder.class);
        rS.insert(r);
    }
}
