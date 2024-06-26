package pe.edu.upc.conexion_24.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "EducationalResource")
public class EducationalResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ResourceType", nullable = false)
    private String ResourceType;
    @Column(name = "ResourceDescription", nullable = false)
    private String ResourceDescription;
    @Column(name = "ResourceStatus", nullable = false)
    private String ResourceStatus;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    public EducationalResource() {
    }

    public EducationalResource(Long id, String resourceType, String resourceDescription, String resourceStatus, Users user) {
        this.id = id;
        ResourceType = resourceType;
        ResourceDescription = resourceDescription;
        ResourceStatus = resourceStatus;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceType() {
        return ResourceType;
    }

    public void setResourceType(String resourceType) {
        ResourceType = resourceType;
    }

    public String getResourceDescription() {
        return ResourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        ResourceDescription = resourceDescription;
    }

    public String getResourceStatus() {
        return ResourceStatus;
    }

    public void setResourceStatus(String resourceStatus) {
        ResourceStatus = resourceStatus;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
