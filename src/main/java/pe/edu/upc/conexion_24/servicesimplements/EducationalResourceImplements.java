package pe.edu.upc.conexion_24.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.conexion_24.entities.EducationalResource;
import pe.edu.upc.conexion_24.repositories.EducationalResourceRepository;
import pe.edu.upc.conexion_24.servicesinterfaces.EducationalResourceService;

import java.util.List;

@Service
public class EducationalResourceImplements implements EducationalResourceService {
    @Autowired
    private EducationalResourceRepository erR;
    @Override
    public void insert(EducationalResource educationalResource) {
        erR.save(educationalResource);
    }

    @Override
    public List<EducationalResource> list() {
        return erR.findAll();
    }
}
