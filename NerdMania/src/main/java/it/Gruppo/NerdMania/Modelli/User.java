package it.Gruppo.NerdMania.Modelli;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user", schema = "NerdMania")
public class User {


    @Id
    private String username;

    private String nome;
    private String cognome;
    private String email;
    private String password;
    private Boolean cartaFedelta;

    @OneToOne(mappedBy = "user")
    private Carrello carrello;

    @OneToMany(mappedBy = "user",  cascade = CascadeType.ALL)
    private List<Ordine> ordini;



}
