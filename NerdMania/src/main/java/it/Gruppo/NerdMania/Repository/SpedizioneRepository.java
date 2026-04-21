package it.Gruppo.NerdMania.Repository;

import it.Gruppo.NerdMania.Modelli.Spedizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpedizioneRepository extends JpaRepository<Spedizione, Integer> {

    //METODO CHE CERCA LE SPEDIZIONI FRAGILI
    List<Spedizione> findByFragileTrue();

    //METODO CHE CERCA LE SPEDIZIONI FATTE ALL'ESTERO
    List<Spedizione> findByEsteroTrue();

    //METODO CHE CERCA LE SPEDIZIONI CON PESO MAGGIORE DI UNO INSERITO IN INPUT
    List<Spedizione> findByPesoGreaterThan(float peso);

    //METODO CHE CERCA LE SPEDIZIONI CON PESO MINORE DI UNO INSERITO IN INPUT
    List<Spedizione> findByPesoLessThan(float peso);

    //METODO CHE CERCA LE SPEDIZIONI CON ALTEZZA TRA UN VALORE E UN ALTRO IN INPUT
    List<Spedizione> findByAltezzaBetween(float min, float max);

    //METODO CHE CERCA LE SPEDIZIONI IN BASE ALL'ID DELL'ORDINE
    List<Spedizione> findByOrdineId(Integer ordineId);

    //METODO CHE CERCA LE SPEDIZIONI CON ALTEZZA O LUNGHEZZA MAGGIORI DEI PARAMETRI IN INPUT
    List<Spedizione> findByAltezzaGreaterThanOrLunghezzaGreaterThan(float h, float l);
}
