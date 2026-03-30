package it.Gruppo.NerdMania.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdottoDto {

    private Long id;

    private String nome;

    private Double prezzo;

    private float peso;

    private String descrizione;
}