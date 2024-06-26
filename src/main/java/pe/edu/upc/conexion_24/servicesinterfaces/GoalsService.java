package pe.edu.upc.conexion_24.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.conexion_24.entities.Goals;
import pe.edu.upc.conexion_24.entities.Publication;

import java.util.List;

public interface GoalsService {
    public void insert(Goals goals);

    public List<Goals> list();

    public void delete(Long id);

    public Goals listId(Long id);
    List<Goals> findByUserId(Long userid);

    List<String[]> countGoalsByName(String nombre);
    public List<String[]> goalsSucceded(Long id);

}
