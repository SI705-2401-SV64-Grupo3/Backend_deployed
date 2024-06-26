package pe.edu.upc.conexion_24.servicesinterfaces;

import pe.edu.upc.conexion_24.entities.EducationalResource;
import pe.edu.upc.conexion_24.entities.Goals;

import java.util.List;

public interface EducationalResourceService {
    public void insert(EducationalResource educationalResource);

    public List<EducationalResource> list();
}
