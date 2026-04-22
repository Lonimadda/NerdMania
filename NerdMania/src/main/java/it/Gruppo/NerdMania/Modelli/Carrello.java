package it.Gruppo.NerdMania.Modelli;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Carrello", schema = "nerdmania")
public class Carrello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double prezzoTotale;
    private Integer quantita;
    private Double peso;

    // NIENTE cascade su User: il carrello non deve creare/aggiornare utenti
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, unique = true)
    @JsonIgnore
    private User user;

    // Anche qui evitiamo cascade ALL per non propagare merge indesiderati
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordine_id", referencedColumnName = "id")
    private Ordine ordine;
}