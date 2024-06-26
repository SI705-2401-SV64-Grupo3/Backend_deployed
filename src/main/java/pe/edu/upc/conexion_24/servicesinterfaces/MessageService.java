package pe.edu.upc.conexion_24.servicesinterfaces;

import pe.edu.upc.conexion_24.entities.Conversation;
import pe.edu.upc.conexion_24.entities.Message;

import java.util.List;

public interface MessageService {
    public void insert(Message message);

    public List<Message> list();

    List<Message> listByConversationId(Long conversationId);

}
