package it.Gruppo.NerdMania.Repository;

import it.Gruppo.NerdMania.Modelli.Carrello;
import it.Gruppo.NerdMania.Modelli.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarrelloRepository extends JpaRepository<Carrello, Integer> {      //LorenzoLombardi

    //Carrello dell’utente (oggetto)
    Optional<Carrello> findByUser(User user);

    //Tutti i carrelli ancora attivi
    List<Carrello> findByOrdineIsNull();

    //Carrelli sopra una certa soglia di prezzo (admin/statistiche)
    List<Carrello> findByPrezzoTotaleGreaterThan(Double prezzo);

    //Carrelli con quantità maggiore di X
    List<Carrello> findByQuantitaGreaterThan(Integer quantita);

    //Carrelli leggeri (spedizioni)
    List<Carrello> findByPesoLessThan(Double peso);
}