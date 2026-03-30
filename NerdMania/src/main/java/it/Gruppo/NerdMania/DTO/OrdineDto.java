package it.Gruppo.NerdMania.DTO;

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

    private float costo_totale;

    private Integer numero_prodotti;

    private String indirizzo_spedizione;

    private User utente;

    private List<Prodotto> prodotti;

    private Spedizione spedizione;
}