package it.Gruppo.NerdMania.Service;

import it.Gruppo.NerdMania.DTO.MagazzinoDto;
import it.Gruppo.NerdMania.DTO.ProdottoDto;
import it.Gruppo.NerdMania.Mapper.Converter;
import it.Gruppo.NerdMania.Mapper.MagazzinoMapper;
import it.Gruppo.NerdMania.Mapper.ProdottoMapper;
import it.Gruppo.NerdMania.Modelli.Magazzino;
import it.Gruppo.NerdMania.Modelli.Prodotto;
import it.Gruppo.NerdMania.Repository.MagazzinoRepository;
import it.Gruppo.NerdMania.Repository.ProdottoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoService extends AbstractService<Prodotto, ProdottoDto> {

    private final ProdottoRepository prodottoRepository;
    private final ProdottoMapper prodottoMapper;

    protected ProdottoService(JpaRepository<Prodotto, Integer> repository, Converter<Prodotto, ProdottoDto> converter, ProdottoMapper prodottoMapper, ProdottoRepository prodottoRepository) {
        super(repository, converter);
        this.prodottoMapper = prodottoMapper;
        this.prodottoRepository = prodottoRepository;
    }

    public List<ProdottoDto> search(String keyword) {
        return prodottoMapper.toDTOList(
                prodottoRepository.search(keyword)
        );
    }

    public List<ProdottoDto> findProdottiEconomici(Double prezzoMax) {
        return prodottoMapper.toDTOList(
                prodottoRepository.findProdottiEconomici(prezzoMax)
        );
    }

    public List<ProdottoDto> findProdottiCostosi(Double prezzoMin) {
        return prodottoMapper.toDTOList(
                prodottoRepository.findProdottiCostosi(prezzoMin)
        );
    }

    public List<ProdottoDto> findByPesoRange(float pesoMin, float pesoMax) {
        return prodottoMapper.toDTOList(
                prodottoRepository.findByPesoRange(pesoMin, pesoMax)
        );
    }

    public List<ProdottoDto> findAllOrderByNome() {
        return prodottoMapper.toDTOList(
                prodottoRepository.findAllOrderByNome()
        );
    }

    public List<ProdottoDto> findByCategoriaId(Long categoriaId) {
        return prodottoMapper.toDTOList(
                prodottoRepository.findByCategoria_Id(categoriaId)
        );
    }
}