package pe.edu.upc.conexion_24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.conexion_24.entities.Goals;

import java.util.List;

@Repository
public interface GoalsRepository extends JpaRepository<Goals, Long> {
    @Query(value = "select g.name_goal, MAX(g.description) as description from goals g join users u on u.id=g.user_id where u.nombres=:nombre \n" +
            "group by g.name_goal",
            nativeQuery = true)
    /**@Query("select g.user.Nombres, count(g) from Goals g WHERE g.user.Nombres =:nombre group by  g.user.Nombres")*/
    List<String[]> countGoalsByName(@Param("nombre") String nombre);

    List<Goals> findByUserId(Long userid);

    @Query(value = "SELECT u.username , COUNT(*) AS quantity FROM Users u JOIN goals g on u.id=g.user_id\n" +
            "WHERE u.id = :id AND estate_goal = 'Logrado'\n" +
            "GROUP BY u.username",nativeQuery = true)
    public List<String[]> goalsSucceded(@Param("id") Long id);

}
