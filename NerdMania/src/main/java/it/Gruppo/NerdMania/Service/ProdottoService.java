package it.Gruppo.NerdMania.Service;

import it.Gruppo.NerdMania.DTO.ProdottoDto;
import it.Gruppo.NerdMania.Mapper.ProdottoMapper;
import it.Gruppo.NerdMania.Modelli.Prodotto;
import it.Gruppo.NerdMania.Repository.ProdottoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoService extends AbstractService<Prodotto, ProdottoDto, Long> {

    private final ProdottoRepository prodottoRepository;
    private final ProdottoMapper prodottoMapper;

    public ProdottoService(ProdottoRepository prodottoRepository,
                           ProdottoMapper prodottoMapper) {
        super(prodottoRepository, prodottoMapper);
        this.prodottoRepository = prodottoRepository;
        this.prodottoMapper = prodottoMapper;
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