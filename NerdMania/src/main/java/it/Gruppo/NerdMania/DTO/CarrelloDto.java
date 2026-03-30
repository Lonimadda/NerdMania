package it.Gruppo.NerdMania.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarrelloDto {          //LorenzoLombardi

    private Integer id;

    private Double prezzoTotale;

    private Integer quantita;

    private Double peso;
}
