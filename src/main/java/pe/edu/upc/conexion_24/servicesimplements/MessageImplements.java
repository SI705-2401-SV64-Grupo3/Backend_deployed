package pe.edu.upc.conexion_24.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.conexion_24.entities.Message;
import pe.edu.upc.conexion_24.repositories.MessageRepository;
import pe.edu.upc.conexion_24.servicesinterfaces.MessageService;

import java.util.List;

@Service
public class MessageImplements implements MessageService {
    @Autowired
    private MessageRepository mR;

    @Override
    public void insert(Message message) {
        mR.save(message);
    }

    @Override
    public List<Message> list() {
        return mR.findAll();
    }

    @Override
    public List<Message> listByConversationId(Long conversationId) {
        return mR.findByConversationId(conversationId);
    }
}
