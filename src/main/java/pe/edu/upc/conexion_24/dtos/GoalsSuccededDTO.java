package pe.edu.upc.conexion_24.dtos;

public class GoalsSuccededDTO {

    public String userName;
    public Long quantityGoals;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getQuantityGoals() {
        return quantityGoals;
    }

    public void setQuantityGoals(Long quantityGoals) {
        this.quantityGoals = quantityGoals;
    }
}
