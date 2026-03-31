package it.Gruppo.NerdMania.Repository;

import it.Gruppo.NerdMania.Modelli.Ordine;
import it.Gruppo.NerdMania.Modelli.Spedizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpedizioneRepository extends JpaRepository<Spedizione, Integer> {

    List<Spedizione> findByFragileTrue();
    List<Spedizione> findByEsteroTrue();
    List<Spedizione> findByPesoGreaterThan(float peso);
    List<Spedizione> findByPesoLessThan(float peso);
    List<Spedizione> findByAltezzaBetween(float min, float max);
    List<Spedizione> findByOrdineId(Integer ordineId);
    List<Spedizione> findByAltezzaGreaterThanOrLunghezzaGreaterThan(float h, float l);
}
