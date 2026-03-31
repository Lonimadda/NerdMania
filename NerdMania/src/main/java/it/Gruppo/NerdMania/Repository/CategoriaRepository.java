package it.Gruppo.NerdMania.Repository;

import it.Gruppo.NerdMania.Modelli.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {

    boolean existsByNome(String nome);

    List<Categoria> findByNomeContainingIgnoreCase(String nome);

    List<Categoria> findAllByOrderByNomeAsc();

}
