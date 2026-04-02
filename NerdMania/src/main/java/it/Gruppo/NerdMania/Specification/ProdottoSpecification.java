package it.Gruppo.NerdMania.Specification;

import it.Gruppo.NerdMania.Modelli.Prodotto;
import org.springframework.data.jpa.domain.Specification;

public class ProdottoSpecification {               //LorenzoLombardi

    public static Specification<Prodotto> nomeContains(String nome) {
        return (root, query, cb) ->
                nome == null ? null :
                        cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
    }

    public static Specification<Prodotto> prezzoMin(Double prezzoMin) {
        return (root, query, cb) ->
                prezzoMin == null ? null :
                        cb.greaterThanOrEqualTo(root.get("prezzo"), prezzoMin);
    }

    public static Specification<Prodotto> prezzoMax(Double prezzoMax) {
        return (root, query, cb) ->
                prezzoMax == null ? null :
                        cb.lessThanOrEqualTo(root.get("prezzo"), prezzoMax);
    }

    public static Specification<Prodotto> categoria(Integer categoriaId) {
        return (root, query, cb) ->
                categoriaId == null ? null :
                        cb.equal(root.get("categoria").get("id"), categoriaId);
    }
}
