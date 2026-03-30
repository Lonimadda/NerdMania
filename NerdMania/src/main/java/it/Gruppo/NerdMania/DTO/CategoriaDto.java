package it.Gruppo.NerdMania.DTO;

import it.Gruppo.NerdMania.Modelli.Prodotto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDto {

    private Long id;
    private String nome;
    private Catalogo catalogo;
    private List<Prodotto> prodotti;
}
