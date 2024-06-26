package pe.edu.upc.conexion_24.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "Users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "idFather", nullable = true)
    private  Long idFather;
    @Column(name = "Username", unique = true, nullable = false)
    private String username;
    @Column(name = "Password", nullable = false, length = 200)
    private String password;
    private Boolean enabled;
    @Column(name = "Name", nullable = false, length = 50)
    private String Name;
    @Column(name = "LastName", nullable = false, length = 50)
    private String LastName;
    @Column(name = "Mail", nullable = false, length = 45)
    private String Mail;
    @Column(name = "BirthDate", nullable = false)
    private LocalDate BirthDate;
    @Column(name = "Genre", nullable = false, length = 10)
    private String Genre;
    @Column(name = "Description", nullable = false, length = 200)
    private String Description;
    @Column(name = "Preference", nullable = false, length = 200)
    private String Preference;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private List<Role> roles;

    public Users() {
    }

    public Users(Long id, Long idFather, String username, String password, Boolean enabled, String name, String lastName, String mail, LocalDate birthDate, String genre, String description, String preference, List<Role> roles) {
        this.id = id;
        this.idFather = idFather;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        Name = name;
        LastName = lastName;
        Mail = mail;
        BirthDate = birthDate;
        Genre = genre;
        Description = description;
        Preference = preference;
        this.roles = roles;
    }

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
