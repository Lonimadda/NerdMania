package it.Gruppo.NerdMania.Repository;

import it.Gruppo.NerdMania.Modelli.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByNomeContainingIgnoreCase(String nome);

    List<User> findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase(
            String nome,
            String cognome
    );

    List<User> findByCognome(String cognome);

    List<User> findByCartaFedeltaTrue();

    List<User> findByCartaFedeltaFalse();

    //controlli di unicità (registrazione)

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    //ordinamento utenti

    List<User> findAllByOrderByNomeAsc();

    List<User> findAllByOrderByCognomeAsc();
}
