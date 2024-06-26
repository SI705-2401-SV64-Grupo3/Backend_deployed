package pe.edu.upc.conexion_24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.conexion_24.entities.Conversation;
@Repository
public interface ConversationRepository extends JpaRepository<Conversation,Long> {

}
