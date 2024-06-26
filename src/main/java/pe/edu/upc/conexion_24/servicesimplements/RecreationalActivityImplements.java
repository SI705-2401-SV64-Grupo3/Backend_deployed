package pe.edu.upc.conexion_24.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.conexion_24.entities.RecreationalActivity;
import pe.edu.upc.conexion_24.repositories.RecreationalActivityRepository;
import pe.edu.upc.conexion_24.servicesinterfaces.RecreationalActivityService;

import java.time.LocalDate;
import java.util.List;

@Service
public class RecreationalActivityImplements implements RecreationalActivityService {
    @Autowired
    private RecreationalActivityRepository raR;
    @Override
    public void insert(RecreationalActivity recreationalActivity) {
        raR.save(recreationalActivity);
    }

    @Override
    public List<RecreationalActivity> list() {
        return raR.findAll();
    }

    @Override
    public List<String[]> countByActivityPopular() {
        return raR.countByActivityPopular();
    }

    @Override
    public List<Object[]> getTotalByDate(LocalDate startDate, LocalDate endDate) {
        return raR.getTotalByDate(startDate,endDate);
    }


}
