package pe.edu.upc.conexion_24.servicesinterfaces;

import pe.edu.upc.conexion_24.entities.Conversation;
import pe.edu.upc.conexion_24.entities.Suggestion;

import java.util.List;

public interface SuggestionService {
    public void insert(Suggestion suggestion);

    public List<Suggestion> list();
}
