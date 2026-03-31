package it.Gruppo.NerdMania.Repository;

import it.Gruppo.NerdMania.Modelli.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdineRepository extends JpaRepository<Ordine, Integer> {

    List<Ordine> findByUserUsername(String username);
    List<Ordine> findAllByOrderByCostoTotaleDesc();
    List<Ordine> findAllByOrderByCostoTotaleAsc();
    List<Ordine> findByIndirizzoSpedizioneContainingIgnoreCase(String testo);
    List<Ordine> findByCostoTotaleGreaterThan(float prezzo);
    List<Ordine> findByCostoTotaleLessThan(float prezzo);
    List<Ordine> findByProdottiId(Integer prodottoId);
}
