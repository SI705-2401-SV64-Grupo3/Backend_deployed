package pe.edu.upc.conexion_24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.conexion_24.entities.EducationalResource;
@Repository
public interface EducationalResourceRepository extends JpaRepository<EducationalResource, Long> {
}
