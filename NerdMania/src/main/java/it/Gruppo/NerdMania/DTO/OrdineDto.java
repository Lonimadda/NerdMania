package it.Gruppo.NerdMania.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.Gruppo.NerdMania.Modelli.Prodotto;
import it.Gruppo.NerdMania.Modelli.Spedizione;
import it.Gruppo.NerdMania.Modelli.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrdineDto {

    private Integer id;

    private float costoTotale;

    private String indirizzoSpedizione;

    private User user;

    private List<Prodotto> prodotti= new ArrayList<>();

    private Spedizione spedizione;
}