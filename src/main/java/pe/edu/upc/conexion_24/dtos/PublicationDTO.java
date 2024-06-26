package pe.edu.upc.conexion_24.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.conexion_24.entities.Users;

import java.time.LocalDate;
import java.time.LocalTime;

public class PublicationDTO {
    private Long id;
    private String Content;
    private LocalDate Date;
    private LocalTime Hour;
    private int Likes;
    private int Shared;
    private Users user;

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

    public int getLikes() {
        return Likes;
    }

    public void setLikes(int likes) {
        Likes = likes;
    }

    public int getShared() {
        return Shared;
    }

    public void setShared(int shared) {
        Shared = shared;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
