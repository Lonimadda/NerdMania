package it.Gruppo.NerdMania.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MagazzinoDto {

    private Integer id;

    private String nome;

    private String indirizzo;

    private String codice;

    private int quantita;

    private List<Long> prodottiId;
}