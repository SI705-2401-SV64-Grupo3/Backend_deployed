package pe.edu.upc.conexion_24.dtos;

public class GoalUserDTO {
    private String Name;
    private Long quantityGoals;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getQuantityGoals() {
        return quantityGoals;
    }

    public void setQuantityGoals(Long quantityGoals) {
        this.quantityGoals = quantityGoals;
    }
}

