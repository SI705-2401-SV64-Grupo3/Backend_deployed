package pe.edu.upc.conexion_24.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Message")

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Content", nullable = false)
    private String Content;
    @Column(name = "Date", nullable = false)
    private LocalDate Date;
    @Column(name = "Hour", nullable = false)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime Hour;
    @Column(name = "StatusMessage", nullable = false, length = 15)
    private String StatusMessage;
    @ManyToOne
    @JoinColumn(name = "conversation_id", nullable = false)
    private Conversation conversation;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    public Message() {
    }

    public Message(Long id, String content, LocalDate date, LocalTime hour, String statusMessage, Conversation conversation, Users user) {
        this.id = id;
        Content = content;
        Date = date;
        Hour = hour;
        StatusMessage = statusMessage;
        this.conversation = conversation;
        this.user = user;
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

    public String getStatusMessage() {
        return StatusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        StatusMessage = statusMessage;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
