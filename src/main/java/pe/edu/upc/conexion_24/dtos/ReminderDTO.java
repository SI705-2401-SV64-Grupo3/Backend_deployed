package pe.edu.upc.conexion_24.dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.conexion_24.entities.Users;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReminderDTO {
    private Long id;
    private LocalDate Date;
    private LocalTime Hour;
    private String Asunt;
    private String message;
    private String StateRecoradatory;
    private Users user;

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
