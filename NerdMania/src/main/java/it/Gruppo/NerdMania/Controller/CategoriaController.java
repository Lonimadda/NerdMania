package it.Gruppo.NerdMania.Controller;

import it.Gruppo.NerdMania.DTO.CategoriaDto;
import it.Gruppo.NerdMania.Repository.CategoriaRepository;
import it.Gruppo.NerdMania.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Categoria")
@CrossOrigin(origins = "http://localhost:8080")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/existsByNome")
    public boolean existsByNome(String nome){
        return categoriaService.existsByNome(nome);
    }

    @GetMapping("/findByNomeContainingIgnoreCase")
    public List<CategoriaDto> findByNomeContainingIgnoreCase(String nome){
        return categoriaService.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/findAllByOrderByNomeAsc")
    public List<CategoriaDto> findAllByOrderByNomeAsc(){
        return categoriaService.findAllByOrderByNomeAsc();
    }

}
