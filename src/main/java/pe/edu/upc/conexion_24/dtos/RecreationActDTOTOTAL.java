package pe.edu.upc.conexion_24.dtos;

import java.time.LocalDate;

public class RecreationActDTOTOTAL {
    private LocalDate date;
    private Long total;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
