package pe.edu.upc.conexion_24.servicesinterfaces;

import pe.edu.upc.conexion_24.entities.Message;
import pe.edu.upc.conexion_24.entities.Notification;

import java.util.List;

public interface NotificationService {
    public void insert(Notification notification);

    public List<Notification> list();
}
