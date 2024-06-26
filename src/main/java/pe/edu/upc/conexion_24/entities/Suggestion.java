package pe.edu.upc.conexion_24.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Suggestion")
public class Suggestion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Content;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    public Suggestion() {
    }

    public Suggestion(Long id, String content, Users user) {
        this.id = id;
        Content = content;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
