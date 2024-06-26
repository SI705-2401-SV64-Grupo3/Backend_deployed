package pe.edu.upc.conexion_24.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.conexion_24.entities.Users;

public class EducationalResourceDTO {
    private Long id;
    private String ResourceType;
    private String ResourceDescription;
    private String ResourceStatus;
    private Users user;

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
