package pe.edu.upc.conexion_24.servicesinterfaces;

import pe.edu.upc.conexion_24.entities.Conversation;
import pe.edu.upc.conexion_24.entities.Goals;

import java.util.List;

public interface ConversationService {
    public void insert(Conversation conversation);

    public List<Conversation> list();
}
