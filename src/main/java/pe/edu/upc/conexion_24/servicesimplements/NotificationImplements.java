package pe.edu.upc.conexion_24.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.conexion_24.entities.Notification;
import pe.edu.upc.conexion_24.repositories.NotificationRepository;
import pe.edu.upc.conexion_24.servicesinterfaces.NotificationService;

import java.util.List;

@Service
public class NotificationImplements implements NotificationService {
    @Autowired
    private NotificationRepository nR;
    @Override
    public void insert(Notification notification) {
        nR.save(notification);
    }

    @Override
    public List<Notification> list() {
        return nR.findAll();
    }
}
