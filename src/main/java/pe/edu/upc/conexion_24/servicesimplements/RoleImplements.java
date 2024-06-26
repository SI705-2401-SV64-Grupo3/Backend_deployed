package pe.edu.upc.conexion_24.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.conexion_24.entities.Role;
import pe.edu.upc.conexion_24.repositories.RoleRepository;
import pe.edu.upc.conexion_24.servicesinterfaces.RoleService;

import java.util.List;

@Service
public class RoleImplements implements RoleService {
    @Autowired
    private RoleRepository rR;
    @Override
    public void insert(Role rol) {
        rR.save(rol);
    }

    @Override
    public List<Role> list() {
        return rR.findAll();
    }

    @Override
    public void delete(Long id) {
        rR.deleteById(id);
    }

    @Override
    public Role listId(Long id) {
        return rR.findById(id).orElse(new Role());
    }

    @Override
    public List<Role> getRoleByRol(String rol) {
        return rR.getRoleByRol(rol);
    }
}
