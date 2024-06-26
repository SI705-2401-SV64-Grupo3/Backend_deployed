package pe.edu.upc.conexion_24.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;
import pe.edu.upc.conexion_24.dtos.UsersDTO;
import pe.edu.upc.conexion_24.entities.Users;

import java.time.LocalDate;
import java.util.List;

public interface UsersService {
    public  void insert(Users users);
    public List<Users> list();

    public void delete(Long id);
    public Users listId(Long id);
    /** public List<Users> findByBirthDate (LocalDate date);
    /**public List<Users> findByGenero (String Genero);*/

    public List<Users> getUsersByGenero(String genero);

    public List<String[]> getByPreference();
    public boolean existsByUsername(String username);




}
