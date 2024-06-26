package pe.edu.upc.conexion_24.dtos;

public class ActivityUserDTO {
    private String NameActivity;
    private Long ParticipatingFamilies;

    public String getNameActivity() {
        return NameActivity;
    }

    public void setNameActivity(String nameActivity) {
        NameActivity = nameActivity;
    }

    public Long getParticipatingFamilies() {
        return ParticipatingFamilies;
    }

    public void setParticipatingFamilies(Long participatingFamilies) {
        ParticipatingFamilies = participatingFamilies;
    }
}
