package pe.edu.upc.conexion_24.servicesinterfaces;

import pe.edu.upc.conexion_24.entities.RecreationalActivity;
import pe.edu.upc.conexion_24.entities.Reminder;

import java.util.List;

public interface ReminderService {
    public void insert(Reminder reminder);

    public List<Reminder> list();

}
