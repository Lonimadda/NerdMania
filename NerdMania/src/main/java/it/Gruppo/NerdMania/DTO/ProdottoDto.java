package it.Gruppo.NerdMania.DTO;

import it.Gruppo.NerdMania.Modelli.Categoria;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdottoDto {

    private Integer id;

    private String nome;

    private Double prezzo;

    private float peso;

    private String descrizione;

    private String immagineUrl;

    private float altezza;
    private float spessore;
    private float lunghezza;
    private boolean fragile;

    private Categoria categoria;
}