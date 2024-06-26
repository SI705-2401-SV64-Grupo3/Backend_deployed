package pe.edu.upc.conexion_24.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.conexion_24.dtos.*;
import pe.edu.upc.conexion_24.entities.Publication;
import pe.edu.upc.conexion_24.entities.Role;
import pe.edu.upc.conexion_24.servicesinterfaces.PublicationService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/publicacion")
@CrossOrigin(origins = "http://localhost:4200")
public class PublicationController {
    @Autowired
    private PublicationService pS;

    @GetMapping
    public List<PublicationDTO> lista(){
        return pS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,PublicationDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody PublicationDTO dto) {
        ModelMapper m = new ModelMapper();
        Publication p = m.map(dto, Publication.class);
        pS.insert(p);
    }

    @PutMapping
    public void modificar(@RequestBody PublicationDTO pdto) {
        ModelMapper m = new ModelMapper();
        Publication p= m.map(pdto, Publication.class);
        pS.insert(p);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        pS.delete(id);
    }

    @GetMapping("/publicacionesInteresantes")
    public List<MostInterestingPublicationsDTO> mejorespublicaciones(@Param("id") Long id){
        List<String[]> listabase = pS.mostInterestingPublications(id);
        List<MostInterestingPublicationsDTO> dtoList = new ArrayList<>();
        for (String[] columna:listabase){
            MostInterestingPublicationsDTO dto = new MostInterestingPublicationsDTO();
            dto.setContentName(columna[0]);
            dto.setShared(Long.valueOf(columna[1]));
            dtoList.add(dto);
        }
        return dtoList;
    }

    @GetMapping("/publicacionesusuarios")
    public List<PublicationByUsersDTO> publicaciones() {
        List<String[]> filaLista = pS.PublicationByUser();
        List<PublicationByUsersDTO> dtoLista = new ArrayList<>();

        for (String[] columna : filaLista) {
            PublicationByUsersDTO dto = new PublicationByUsersDTO();
            dto.setName(columna[0]);
            dto.setPublicationByUser(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/likesusuarios")
    public List<LikeByUsersDTO> likes() {
        List<String[]> filaLista = pS.LikesByUser();
        List<LikeByUsersDTO> dtoLista = new ArrayList<>();

        for (String[] columna : filaLista) {
            LikeByUsersDTO dto = new LikeByUsersDTO();
            dto.setName(columna[0]);
            dto.setMostLikesUser(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
