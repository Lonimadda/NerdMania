package it.Gruppo.NerdMania.DTO;

import it.Gruppo.NerdMania.Modelli.Ordine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpedizioneDto {

    private Integer id;

    private float altezza;
    private float spessore;
    private boolean fragile;
    private float lunghezza;

    private float peso;

    private boolean estero;

    private Ordine ordine;
}