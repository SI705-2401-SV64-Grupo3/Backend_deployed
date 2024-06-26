package pe.edu.upc.conexion_24.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.conexion_24.entities.Goals;
import pe.edu.upc.conexion_24.repositories.GoalsRepository;
import pe.edu.upc.conexion_24.servicesinterfaces.GoalsService;

import java.util.List;

@Service
public class GoalsImplements implements GoalsService {
    @Autowired
    private GoalsRepository gR;
    @Override
    public void insert(Goals goals) {
        gR.save( goals);
    }

    @Override
    public List<Goals> list() {
        return gR.findAll();
    }

    @Override
    public void delete(Long id) {
        gR.deleteById(id);
    }

    @Override
    public Goals listId(Long id) {
        return gR.findById(id).orElse(new Goals());
    }

    @Override
    public List<Goals> findByUserId(Long userid) {
        return gR.findByUserId(userid);
    }


    @Override
    public List<String[]> countGoalsByName(String nombre) {
        return gR.countGoalsByName(nombre);
    }

    @Override
    public List<String[]> goalsSucceded(Long id) {
        return gR.goalsSucceded(id);
    }

}
