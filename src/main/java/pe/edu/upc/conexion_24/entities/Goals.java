package pe.edu.upc.conexion_24.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "Goals")
public class Goals implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NameGoal",nullable = false)
    private String NameGoal;
    @Column(name = "Description",nullable = false,length = 300)
    private String Description;
    @Column(name = "EstateGoal",nullable = false)
    private String EstateGoal;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private Users user;


    public Goals() {

    }

    public Goals(Long id, String nameGoal, String description, String estateGoal, Users user) {
        this.id = id;
        NameGoal = nameGoal;
        Description = description;
        EstateGoal = estateGoal;
        this.user = user;
    }

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
