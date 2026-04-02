package it.Gruppo.NerdMania.Modelli;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Magazzino", schema = "nerdmania")
public class Magazzino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String indirizzo;

    private String codice;

    private int quantita;


    @ManyToMany
    @JoinTable(
            name = "magazzino_prodotto",
            schema = "nerdmania",
            joinColumns = @JoinColumn(name = "magazzino_id"),
            inverseJoinColumns = @JoinColumn(name = "prodotto_id")
    )
    @JsonIgnore
    private List<Prodotto> prodotti;
}