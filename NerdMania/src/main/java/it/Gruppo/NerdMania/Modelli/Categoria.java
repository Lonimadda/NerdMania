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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Categoria", schema = "nerdmania")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "catalogo_id", nullable = false)
    @JsonIgnore
    private Catalogo catalogo;

    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    private List<Prodotto> prodotti;
}