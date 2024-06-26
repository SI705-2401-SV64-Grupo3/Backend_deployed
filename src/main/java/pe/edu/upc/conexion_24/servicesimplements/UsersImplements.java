package pe.edu.upc.conexion_24.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.conexion_24.entities.Users;
import pe.edu.upc.conexion_24.repositories.UserRepository;
import pe.edu.upc.conexion_24.servicesinterfaces.UsersService;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsersImplements implements UsersService {
    @Autowired
    private UserRepository uR;
    @Override
    public void insert(Users users) {
        uR.save(users);
    }

    @Override
    public List<Users> list() {
        return uR.findAll();
    }

    @Override
    public void delete(Long id) {
        uR.deleteById(id);
    }

    @Override
    public Users listId(Long id) {
        return uR.findById(id).orElse(new Users());
    }
    /**
    @Override
    public List<Users> findByBirthDate(LocalDate date) {
        return uR.findByBirthDate(date);
    }
    /**@Override
    public List<Users> findByGenero(String Genero) {
    return uR.findByGenero(Genero);
    }*/
    @Override
    public List<Users> getUsersByGenero(String genero) {
        return uR.getUsersByGenero(genero);
    }

    @Override
    public List<String[]> getByPreference() {
        return uR.getByPreference();
    }

    @Override
    public boolean existsByUsername(String username) {
        return uR.existsByUsername(username);
    }

}
