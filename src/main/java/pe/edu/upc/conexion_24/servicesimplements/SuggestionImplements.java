package pe.edu.upc.conexion_24.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.conexion_24.entities.Conversation;
import pe.edu.upc.conexion_24.entities.Suggestion;
import pe.edu.upc.conexion_24.repositories.SuggestionRepository;
import pe.edu.upc.conexion_24.servicesinterfaces.SuggestionService;

import java.util.List;

@Service
public class SuggestionImplements implements SuggestionService {
    @Autowired
    private SuggestionRepository sR;
    @Override
    public void insert(Suggestion suggestion) {
        sR.save(suggestion);
    }

    @Override
    public List<Suggestion> list() {
        return sR.findAll();
    }
}
