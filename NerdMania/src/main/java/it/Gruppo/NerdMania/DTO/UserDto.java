package it.Gruppo.NerdMania.DTO;

import it.Gruppo.NerdMania.Modelli.Ruolo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Integer id;

    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private Boolean cartaFedelta;
    private Ruolo ruolo;

    private CarrelloDto carrello;

    private List<OrdineDto> ordini;

}
