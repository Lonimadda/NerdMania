package it.Gruppo.NerdMania.Repository;

import it.Gruppo.NerdMania.Modelli.Magazzino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagazzinoRepository extends JpaRepository<Magazzino, Long> {

    // Ricerca per nome o indirizzo
    @Query("SELECT m FROM Magazzino m WHERE LOWER(m.nome) LIKE LOWER(CONCAT('%', ?1, '%')) OR LOWER(m.indirizzo) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<Magazzino> search(String keyword);

    // Magazzini con scorte basse
    @Query("SELECT m FROM Magazzino m WHERE m.quantita < ?1")
    List<Magazzino> findMagazziniConScorteBasse(int soglia);

    // Magazzini con scorte alte
    @Query("SELECT m FROM Magazzino m WHERE m.quantita > ?1")
    List<Magazzino> findMagazziniConScorteAlte(int soglia);

    // Trova magazzino per codice
    Magazzino findByCodice(String codice);

    // Magazzini che contengono un prodotto specifico
    @Query("SELECT m FROM Magazzino m JOIN m.prodotti p WHERE p.id = ?1")
    List<Magazzino> findMagazziniByProdottoId(Long prodottoId);

    // magazzini che contengono prodotti per nome
    @Query("SELECT m FROM Magazzino m JOIN m.prodotti p WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<Magazzino> findMagazziniByNomeProdotto(String nomeProdotto);

}