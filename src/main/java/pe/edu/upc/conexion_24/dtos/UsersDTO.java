package pe.edu.upc.conexion_24.dtos;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class UsersDTO {
    private Long id;
    private Long idFather;
    private String username;
    private String password;
    private Boolean enabled;
    private String Name;
    private String LastName;
    private String Mail;
    private LocalDate BirthDate;
    private String Genre;
    private String Description;
    private String Preference;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdFather() {
        return idFather;
    }

    public void setIdFather(Long idFather) {
        this.idFather = idFather;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPreference() {
        return Preference;
    }

    public void setPreference(String preference) {
        Preference = preference;
    }
}