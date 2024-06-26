package pe.edu.upc.conexion_24.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.conexion_24.entities.Publication;
import pe.edu.upc.conexion_24.repositories.PublicationRepository;
import pe.edu.upc.conexion_24.servicesinterfaces.PublicationService;

import java.util.List;

@Service
public class PublicationImplements implements PublicationService {
    @Autowired
    private PublicationRepository pR;

    @Override
    public void insert(Publication publication) {
        pR.save(publication);
    }

    @Override
    public List<Publication> list() {
        return pR.findAll();
    }

    @Override
    public void delete(Long id) {
        pR.deleteById(id);
    }

    @Override
    public Publication listId(Long id) {
        return pR.findById(id).orElse(new Publication());
    }

    @Override
    public List<String[]> mostInterestingPublications(Long id) {
        return pR.mostInterestingPublications(id);
    }

    @Override
    public List<String[]> PublicationByUser() {
        return pR.PublicationByUser();
    }

    @Override
    public List<String[]> LikesByUser() {
        return pR.LikesByUser();
    }

}
