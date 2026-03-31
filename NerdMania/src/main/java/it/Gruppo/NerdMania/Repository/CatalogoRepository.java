package it.Gruppo.NerdMania.Repository;

import it.Gruppo.NerdMania.Modelli.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {            //LorenzoLombardi

    // 🔎 Trova catalogo per nome
    Optional<Catalogo> findByNome(String nome);

    // 🔍 Controlla se esiste un catalogo con quel nome
    boolean existsByNome(String nome);

    // 🔎 Trova cataloghi che contengono una parola nel nome
    List<Catalogo> findByNomeContaining(String nome);

    // 🔎 Trova cataloghi che iniziano con
    List<Catalogo> findByNomeStartingWith(String nome);

    // 🔎 Trova cataloghi che finiscono con
    List<Catalogo> findByNomeEndingWith(String nome);

    // 📦 Trova cataloghi che hanno categorie associate
    List<Catalogo> findByCategorieIsNotNull();

    // 📦 Trova cataloghi senza categorie (vuoti)
    List<Catalogo> findByCategorieIsNull();

    // 📊 Trova cataloghi con più di X categorie
    List<Catalogo> findByCategorie_SizeGreaterThan(int size);
}