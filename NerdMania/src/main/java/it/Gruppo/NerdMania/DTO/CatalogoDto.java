package it.Gruppo.NerdMania.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CatalogoDto {                              //LorenzoLombardi

    private Long id;

    private String nome;

    private List<Categoria> categorie;
}
