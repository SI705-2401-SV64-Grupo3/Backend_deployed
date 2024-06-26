package pe.edu.upc.conexion_24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.conexion_24.entities.Suggestion;

import java.util.List;

@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {
    @Query("SELECT u.Name as usuario, s.Content \n" +
            "FROM  Suggestion s \n" +
            "INNER JOIN Users u ON s.user.id = u.id")
    public List<String[]> getSuggestionBy();

}
