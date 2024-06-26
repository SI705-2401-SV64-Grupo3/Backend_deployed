package pe.edu.upc.conexion_24.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "RecreationalActivity")
public class RecreationalActivity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Date", nullable = false)
    private LocalDate Date;
    @Column(name = "DurationActivity", nullable = false)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime DurationActivity;
    @Column(name = "NameActivity", nullable = false)
    private String NameActivity;
    @Column(name = "PlaceActivity", nullable = false)
    private String PlaceActivity;
    @Column(name = "Description", nullable = false)
    private String Description;
    @ManyToOne
    @JoinColumn(name = "user_id1", nullable = false)
    private Users user1;
    @ManyToOne
    @JoinColumn(name = "user_id2", nullable = false)
    private Users user2;

    public RecreationalActivity() {
    }

    public RecreationalActivity(Long id, LocalDate date, LocalTime durationActivity, String nameActivity, String placeActivity, String description, Users user1, Users user2) {
        this.id = id;
        Date = date;
        DurationActivity = durationActivity;
        NameActivity = nameActivity;
        PlaceActivity = placeActivity;
        Description = description;
        this.user1 = user1;
        this.user2 = user2;
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
