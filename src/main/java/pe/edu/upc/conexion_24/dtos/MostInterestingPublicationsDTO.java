package pe.edu.upc.conexion_24.dtos;

public class MostInterestingPublicationsDTO {
    public String contentName;
    public Long shared;

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public Long getShared() {
        return shared;
    }

    public void setShared(Long shared) {
        this.shared = shared;
    }
}
