package pe.edu.upc.conexion_24.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Reminder")
public class Reminder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Date",nullable = false)
    private LocalDate Date;
    @Column(name = "Hour",nullable = false)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime Hour;
    @Column(name = "Asunt",nullable = false)
    private String Asunt;
    @Column(name = "message",nullable = true)
    private String message;
    @Column(name = "StateRecoradatory",nullable = true)
    private String StateRecoradatory;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    public Reminder() {
    }

    public Reminder(Long id, LocalDate date, LocalTime hour, String asunt, String message, String stateRecoradatory, Users user) {
        this.id = id;
        Date = date;
        Hour = hour;
        Asunt = asunt;
        this.message = message;
        StateRecoradatory = stateRecoradatory;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public LocalTime getHour() {
        return Hour;
    }

    public void setHour(LocalTime hour) {
        Hour = hour;
    }

    public String getAsunt() {
        return Asunt;
    }

    public void setAsunt(String asunt) {
        Asunt = asunt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStateRecoradatory() {
        return StateRecoradatory;
    }

    public void setStateRecoradatory(String stateRecoradatory) {
        StateRecoradatory = stateRecoradatory;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
