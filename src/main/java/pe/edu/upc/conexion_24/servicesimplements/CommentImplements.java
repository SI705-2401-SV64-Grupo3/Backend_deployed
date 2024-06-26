package pe.edu.upc.conexion_24.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.conexion_24.entities.Comment;
import pe.edu.upc.conexion_24.repositories.CommentRepository;
import pe.edu.upc.conexion_24.servicesinterfaces.CommentService;

import java.util.List;

@Service
public class CommentImplements implements CommentService {
    @Autowired
    private CommentRepository cR;

    @Override
    public void insert(Comment comment) {
        cR.save(comment);
    }

    @Override
    public List<Comment> list() {
        return cR.findAll();
    }
}
