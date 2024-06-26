package pe.edu.upc.conexion_24.dtos;

public class LikeByUsersDTO {
    private String name;
    private int MostLikesUser;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMostLikesUser() {
        return MostLikesUser;
    }

    public void setMostLikesUser(int mostLikesUser) {
        MostLikesUser = mostLikesUser;
    }
}
