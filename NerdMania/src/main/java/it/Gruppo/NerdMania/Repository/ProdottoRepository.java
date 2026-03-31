package it.Gruppo.NerdMania.Repository;

import it.Gruppo.NerdMania.Modelli.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {

    // Ricerca per nome o descrizione
    @Query("SELECT p FROM Prodotto p WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', ?1, '%')) OR LOWER(p.descrizione) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<Prodotto> search(String keyword);

    // Prodotti economici
    @Query("SELECT p FROM Prodotto p WHERE p.prezzo <= ?1 ORDER BY p.prezzo ASC")
    List<Prodotto> findProdottiEconomici(Double prezzoMax);

    // Prodotti costosi
    @Query("SELECT p FROM Prodotto p WHERE p.prezzo >= ?1 ORDER BY p.prezzo DESC")
    List<Prodotto> findProdottiCostosi(Double prezzoMin);

    // Prodotti per fascia di peso
    @Query("SELECT p FROM Prodotto p WHERE p.peso BETWEEN ?1 AND ?2")
    List<Prodotto> findByPesoRange(float pesoMin, float pesoMax);

    // Catalogo ordinato per nome
    @Query("SELECT p FROM Prodotto p ORDER BY p.nome ASC")
    List<Prodotto> findAllOrderByNome();

    // EXTRA utile: prodotti per categoria (relazione ManyToOne)
    List<Prodotto> findByCategoria_Id(Long categoriaId);

}