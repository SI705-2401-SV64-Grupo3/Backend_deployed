package pe.edu.upc.conexion_24.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "Publication")
public class Publication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Content",nullable = false, length = 300)
    private String Content;
    @Column(name = "Date",nullable = false)
    private LocalDate Date;
    @Column(name = "Hour",nullable = false)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime Hour;

    @Column(name = "Likes",nullable = false)
    private int Likes;
    @Column(name = "Shared",nullable = false)
    private int Shared;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id")
    @JsonIgnore
    private List<Comment> comment;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "notification_id")
    @JsonIgnore
    private List<Notification> notification;

    public Publication() {
    }

    public Publication(Long id, String content, LocalDate date, LocalTime hour, int likes, int shared, Users user, List<Comment> comment, List<Notification> notification) {
        this.id = id;
        Content = content;
        Date = date;
        Hour = hour;
        Likes = likes;
        Shared = shared;
        this.user = user;
        this.comment = comment;
        this.notification = notification;
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

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public List<Notification> getNotification() {
        return notification;
    }

    public void setNotification(List<Notification> notification) {
        this.notification = notification;
    }
}
