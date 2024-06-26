package pe.edu.upc.conexion_24.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.conexion_24.entities.Publication;

import java.time.LocalDate;
import java.time.LocalTime;

public class CommentDTO {
    private Long id;
    private String Content;
    private LocalDate Date;
    private LocalTime Hour;
    private Publication publication;

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

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }
}
