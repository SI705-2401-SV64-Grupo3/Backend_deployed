package pe.edu.upc.conexion_24.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.conexion_24.entities.Reminder;
import pe.edu.upc.conexion_24.repositories.ReminderRepository;
import pe.edu.upc.conexion_24.servicesinterfaces.ReminderService;

import java.util.List;

@Service
public class ReminderImplements implements ReminderService {
    @Autowired
    private ReminderRepository rR;
    @Override
    public void insert(Reminder reminder) {
        rR.save(reminder);
    }

    @Override
    public List<Reminder> list() {
        return rR.findAll();
    }
}
