package pe.edu.upc.conexion_24.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.conexion_24.entities.Users;

public class GoalsDTO {
    private Long id;
    private String NameGoal;
    private String Description;
    private String EstateGoal;
    private Users user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameGoal() {
        return NameGoal;
    }

    public void setNameGoal(String nameGoal) {
        NameGoal = nameGoal;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getEstateGoal() {
        return EstateGoal;
    }

    public void setEstateGoal(String estateGoal) {
        EstateGoal = estateGoal;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
