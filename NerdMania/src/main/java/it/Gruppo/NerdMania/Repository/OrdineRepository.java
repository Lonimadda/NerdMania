package it.Gruppo.NerdMania.Repository;

import it.Gruppo.NerdMania.Modelli.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Integer> {

    //METODO CHE CERCA GLI ORDINI IN BASE ALL'USERNAME DELL'UTENTE
    List<Ordine> findByUserUsername(String username);

    //METODO CHE CERCA GLI ORDINI IN ORDINE DECRESCENTE PER COSTO TOTALE
    List<Ordine> findAllByOrderByCostoTotaleDesc();

    //METODO CHE CERCA GLI ORDINI IN ORDINE CRESCENTE PER COSTO TOTALE
    List<Ordine> findAllByOrderByCostoTotaleAsc();

    //METODO CHE CERCA GLI ORDINI IN BASE ALL'INDIRIZZO DI SPEDIZIONE
    List<Ordine> findByIndirizzoSpedizioneContainingIgnoreCase(String testo);

    //METODO CHE CERCA GLI ORDINI IN BASE AL COSTO TOTALE MAGGIORE DI UN CERTO INPUT
    List<Ordine> findByCostoTotaleGreaterThan(float prezzo);

    //METODO CHE CERCA GLI ORDINI IN BASE AL COSTO TOTALE MINORE DI UN CERTO INPUT
    List<Ordine> findByCostoTotaleLessThan(float prezzo);

    //METODO CHE CERCA GLI ORDINI CHE CONTENGONO UN CERTO PRODOTTO
    List<Ordine> findByProdottiId(Integer prodottoId);
}
