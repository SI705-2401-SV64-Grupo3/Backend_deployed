package pe.edu.upc.conexion_24.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Content",nullable = false)
    private String Content;
    @Column(name = "Date",nullable = false)
    private LocalDate Date;
    @Column(name = "Hour",nullable = false)
    private LocalTime Hour;

    @ManyToOne
    @JoinColumn(name = "publication_id", nullable = false)
    private Publication publication;

    public Comment() {
    }

    public Comment(Long id, String content, LocalDate date, LocalTime hour, Publication publication) {
        this.id = id;
        Content = content;
        Date = date;
        Hour = hour;
        this.publication = publication;
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
