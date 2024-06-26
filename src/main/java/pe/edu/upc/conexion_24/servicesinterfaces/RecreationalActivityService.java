package pe.edu.upc.conexion_24.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.conexion_24.entities.Comment;
import pe.edu.upc.conexion_24.entities.RecreationalActivity;

import java.time.LocalDate;
import java.util.List;

public interface RecreationalActivityService {
    public void insert(RecreationalActivity recreationalActivity);

    public List<RecreationalActivity> list();

    public List<String[]> countByActivityPopular();

    List<Object[]> getTotalByDate(LocalDate startDate, LocalDate endDate);


}
