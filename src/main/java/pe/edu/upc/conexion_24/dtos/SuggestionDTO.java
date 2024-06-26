package pe.edu.upc.conexion_24.dtos;

import pe.edu.upc.conexion_24.entities.Users;

public class SuggestionDTO {
    private Long id;
    private String Content;
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
