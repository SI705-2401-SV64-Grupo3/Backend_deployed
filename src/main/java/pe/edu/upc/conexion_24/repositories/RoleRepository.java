package pe.edu.upc.conexion_24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.conexion_24.entities.Role;
import pe.edu.upc.conexion_24.entities.Users;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("select r from Role r WHERE r.rol =:rol")
    public List<Role> getRoleByRol(@Param("rol") String rol);
}
