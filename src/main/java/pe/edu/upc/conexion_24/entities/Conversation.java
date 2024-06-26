package pe.edu.upc.conexion_24.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Conversation")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate StartDate;
    @ManyToOne
    @JoinColumn(name = "user_id1", nullable = false)
    private Users user1;
    @ManyToOne
    @JoinColumn(name = "user_id2", nullable = false)
    private Users user2;

    public Conversation() {
    }

    public Conversation(Long id, LocalDate startDate, Users user1, Users user2) {
        this.id = id;
        StartDate = startDate;
        this.user1 = user1;
        this.user2 = user2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public Users getUser1() {
        return user1;
    }

    public void setUser1(Users user1) {
        this.user1 = user1;
    }

    public Users getUser2() {
        return user2;
    }

    public void setUser2(Users user2) {
        this.user2 = user2;
    }
}
