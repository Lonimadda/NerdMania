package it.Gruppo.NerdMania.Modelli;

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
@Table(name = "Carrello", schema = "NerdMania")
public class Carrello {                      //LorenzoLombardi

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double prezzoTotale;

    private Integer quantita;

    private Double peso;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ordine_id", referencedColumnName = "id")
    private Ordine ordine;


}
