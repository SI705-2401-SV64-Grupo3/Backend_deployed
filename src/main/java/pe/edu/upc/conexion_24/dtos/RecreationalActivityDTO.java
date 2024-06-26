package pe.edu.upc.conexion_24.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.conexion_24.entities.Users;

import java.time.LocalDate;
import java.time.LocalTime;

public class RecreationalActivityDTO {
    private Long id;
    private LocalDate Date;
    private LocalTime DurationActivity;
    private String NameActivity;
    private String PlaceActivity;
    private String Description;

    private Users user1;
    private Users user2;

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

    public LocalTime getDurationActivity() {
        return DurationActivity;
    }

    public void setDurationActivity(LocalTime durationActivity) {
        DurationActivity = durationActivity;
    }

    public String getNameActivity() {
        return NameActivity;
    }

    public void setNameActivity(String nameActivity) {
        NameActivity = nameActivity;
    }

    public String getPlaceActivity() {
        return PlaceActivity;
    }

    public void setPlaceActivity(String placeActivity) {
        PlaceActivity = placeActivity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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
