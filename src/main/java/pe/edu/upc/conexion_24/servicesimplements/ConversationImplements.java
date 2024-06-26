package pe.edu.upc.conexion_24.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.conexion_24.entities.Conversation;
import pe.edu.upc.conexion_24.repositories.ConversationRepository;
import pe.edu.upc.conexion_24.servicesinterfaces.ConversationService;

import java.util.List;

@Service
public class ConversationImplements implements ConversationService {
    @Autowired
    private ConversationRepository cR;
    @Override
    public void insert(Conversation conversation) {
        cR.save(conversation);
    }

    @Override
    public List<Conversation> list() {
        return cR.findAll();
    }
}
