package pe.edu.upc.conexion_24.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.conexion_24.dtos.MessageDTO;
import pe.edu.upc.conexion_24.dtos.NotificationDTO;
import pe.edu.upc.conexion_24.entities.Message;
import pe.edu.upc.conexion_24.entities.Notification;
import pe.edu.upc.conexion_24.servicesinterfaces.NotificationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
@CrossOrigin(origins = "http://localhost:4200")
public class NotificationController {
    @Autowired
    private NotificationService nS;

    @GetMapping
    public List<NotificationDTO> lista(){
        return nS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,NotificationDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody NotificationDTO dto) {
        ModelMapper m = new ModelMapper();
        Notification n = m.map(dto, Notification.class);
        nS.insert(n);
    }
}
