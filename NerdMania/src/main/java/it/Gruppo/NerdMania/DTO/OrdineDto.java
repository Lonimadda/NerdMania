package it.Gruppo.NerdMania.DTO;

import it.Gruppo.NerdMania.Modelli.Prodotto;
import it.Gruppo.NerdMania.Modelli.Spedizione;
import it.Gruppo.NerdMania.Modelli.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdineDto {

    private Integer id;

    private float costoTotale;

    private Integer numeroProdotti;

    private String indirizzoSpedizione;

    private User utente;

    private List<Prodotto> prodotti;

    private Spedizione spedizione;
}