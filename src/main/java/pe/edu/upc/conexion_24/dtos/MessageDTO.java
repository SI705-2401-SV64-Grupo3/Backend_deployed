package pe.edu.upc.conexion_24.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.conexion_24.entities.Conversation;
import pe.edu.upc.conexion_24.entities.Users;

import java.time.LocalDate;
import java.time.LocalTime;

public class MessageDTO {
    private Long id;
    private String Content;
    private LocalDate Date;

    private LocalTime Hour;
    private String StatusMessage;
    private Conversation conversation;
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
