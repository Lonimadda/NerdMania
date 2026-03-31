package it.Gruppo.NerdMania.Modelli;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer id;

    private String nome;

    private Double prezzo;

    private float peso;

    private String descrizione;

    @ManyToMany(mappedBy = "prodotti")
    @JsonIgnore
    private List<Ordine> ordini;

    @ManyToMany(mappedBy = "prodotti")
    @JsonIgnore
    private List<Magazzino> magazzini;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @JsonIgnore
    private Categoria categoria;

}