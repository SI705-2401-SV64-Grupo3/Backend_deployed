package pe.edu.upc.conexion_24.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.conexion_24.dtos.ActivityUserDTO;
import pe.edu.upc.conexion_24.dtos.CommentDTO;
import pe.edu.upc.conexion_24.dtos.RecreationActDTOTOTAL;
import pe.edu.upc.conexion_24.dtos.RecreationalActivityDTO;
import pe.edu.upc.conexion_24.entities.Comment;
import pe.edu.upc.conexion_24.entities.RecreationalActivity;
import pe.edu.upc.conexion_24.servicesinterfaces.RecreationalActivityService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actividadrecreativa")
@CrossOrigin(origins = "http://localhost:4200")
public class RecreationalActivityController {
    @Autowired
    private RecreationalActivityService raS;

    @GetMapping
    public List<RecreationalActivityDTO> lista(){
        return raS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,RecreationalActivityDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void registrar(@RequestBody RecreationalActivityDTO dto) {
        ModelMapper m = new ModelMapper();
        RecreationalActivity ra = m.map(dto, RecreationalActivity.class);
        raS.insert(ra);
    }

    @GetMapping("/actividadpopular")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<ActivityUserDTO> activitypopular(){
        List<String[]> lista1 = raS.countByActivityPopular();
        List<ActivityUserDTO> dtolist = new ArrayList<>();
        for (String[] activity : lista1){
            ActivityUserDTO dto = new ActivityUserDTO();
            dto.setNameActivity(activity[0]);
            dto.setParticipatingFamilies(Long.parseLong(activity[1]));
            dtolist.add(dto);
        }
        return dtolist;

    }
    @GetMapping("/totalporfecha")
    public List<RecreationActDTOTOTAL> getTotalByDate(@RequestParam("startDate") LocalDate startDate,
                                                      @RequestParam("endDate") LocalDate endDate) {
        List<Object[]> result = raS.getTotalByDate(startDate, endDate);
        List<RecreationActDTOTOTAL> dtolist = new ArrayList<>();
        for (Object[] row : result) {
            RecreationActDTOTOTAL dto = new RecreationActDTOTOTAL();
            dto.setDate((LocalDate) row[0]); // Assuming the first column is of type LocalDate
            dto.setTotal((Long) row[1]);     // Assuming the second column is of type Long
            dtolist.add(dto);
        }
        return dtolist;
    }




}
