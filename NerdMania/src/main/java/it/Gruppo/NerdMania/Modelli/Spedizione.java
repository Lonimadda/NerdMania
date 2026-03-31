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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "spedizione", schema = "nerdmania")
public class Spedizione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean fragile;

    private float altezza;

    private float spessore;

    private float lunghezza;

    private float peso;

    private boolean estero;

    @OneToOne
    @JoinColumn(name = "ordine_id")
    @JsonIgnore
    private Ordine ordine;
}
