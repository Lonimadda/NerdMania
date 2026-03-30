package it.Gruppo.NerdMania.Modelli;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Prodotto", schema = "nerdmania")
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private Double prezzo;

    private float peso;

    private String descrizione;

    @ManyToMany(mappedBy = "prodotti")
    private List<Ordine> ordini;

    @ManyToMany(mappedBy = "prodotti")
    private List<Magazzino> magazzini;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}