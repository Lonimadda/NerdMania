package it.Gruppo.NerdMania.DTO;

import it.Gruppo.NerdMania.Modelli.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CatalogoDto {                              //LorenzoLombardi

    private Long id;

    private String nome;

    private List<Categoria> categorie;
}
