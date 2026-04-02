package it.Gruppo.NerdMania.Service;


import it.Gruppo.NerdMania.DTO.ProdottoDto;
import it.Gruppo.NerdMania.Mapper.Converter;
import it.Gruppo.NerdMania.Mapper.ProdottoMapper;
import it.Gruppo.NerdMania.Modelli.Prodotto;
import it.Gruppo.NerdMania.Repository.ProdottoRepository;
import it.Gruppo.NerdMania.Specification.ProdottoSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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

    public Page<ProdottoDto> getProdottiFiltrati(
            String nome,
            Double prezzoMin,
            Double prezzoMax,
            Integer categoriaId,
            Pageable pageable) {

        Specification<Prodotto> spec = Specification
                .where(ProdottoSpecification.nomeContains(nome))
                .and(ProdottoSpecification.prezzoMin(prezzoMin))
                .and(ProdottoSpecification.prezzoMax(prezzoMax))
                .and(ProdottoSpecification.categoria(categoriaId));

        return prodottoRepository.findAll(spec, pageable)
                .map(prodottoMapper::toDTO);
    }

    public Page<ProdottoDto> getProdottiPaginati(Pageable pageable) {
        return prodottoRepository.findAll(pageable)
                .map(prodottoMapper::toDTO);
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