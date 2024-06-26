package pe.edu.upc.conexion_24.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.conexion_24.entities.Role;

import java.util.List;

public interface RoleService {
    public void insert(Role rol);

    public List<Role> list();

    public void delete(Long id);

    public Role listId(Long id);

    public List<Role> getRoleByRol(String rol);

}
