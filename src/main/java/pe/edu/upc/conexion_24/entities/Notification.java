package pe.edu.upc.conexion_24.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Content",nullable = false)
    private String Content;
    @Column(name = "Date",nullable = false)
    private LocalDate Date;
    @ManyToOne
    @JoinColumn(name = "publication_id", nullable = false)
    private Publication publication;

    public Notification() {
    }

    public Notification(Long id, String content, LocalDate date, Publication publication) {
        this.id = id;
        Content = content;
        Date = date;
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

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }
}
