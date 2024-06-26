package pe.edu.upc.conexion_24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.conexion_24.entities.Publication;

import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
    @Query(value = "select p.content,p.shared from users u join publication p \n" +
            "on u.id=p.user_id where u.id=:id \n" +
            "group by p.content,p.shared \n" +
            "order by shared desc",nativeQuery = true)
    public List<String[]> mostInterestingPublications(@Param("id") Long id);

    @Query(value = "select u.name as Usuario, count(*) as Publicaciones\n" +
            "                        from users u  inner join publication p \n" +
            "                        on u.id=p.user_id \n" +
            "                       group by u.name\n" +
            "\t\t\t\t\t   ORDER BY COUNT(*) DESC;",nativeQuery = true)
    public List<String[]> PublicationByUser();

    @Query(value = "SELECT u.name as Usuario, p.likes\n" +
            "FROM users u\n" +
            "INNER JOIN publication p ON u.id = p.user_id\n" +
            "INNER JOIN (\n" +
            "    SELECT user_id, MAX(likes) AS max_likes\n" +
            "    FROM publication\n" +
            "    GROUP BY user_id\n" +
            ") AS max_likes_per_user ON p.user_id = max_likes_per_user.user_id AND p.likes = max_likes_per_user.max_likes\n" +
            "ORDER BY u.name",nativeQuery = true)
    public List<String[]> LikesByUser();
}
