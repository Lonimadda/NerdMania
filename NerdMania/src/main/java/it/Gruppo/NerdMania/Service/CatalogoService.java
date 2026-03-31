package it.Gruppo.NerdMania.Service;

import it.Gruppo.NerdMania.DTO.CatalogoDto;
import it.Gruppo.NerdMania.Mapper.CatalogoMapper;
import it.Gruppo.NerdMania.Mapper.Converter;
import it.Gruppo.NerdMania.Modelli.Catalogo;
import it.Gruppo.NerdMania.Repository.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoService extends AbstractService<Catalogo, CatalogoDto>{         //LorenzoLombardi

    private final CatalogoMapper catalogoMapper;
    private final CatalogoRepository catalogoRepository;

    @Autowired
    public CatalogoService(JpaRepository<Catalogo, Integer> repository,
                           Converter<Catalogo, CatalogoDto> converter,
                           CatalogoMapper catalogoMapper,
                           CatalogoRepository catalogoRepository) {
        super(repository, converter);
        this.catalogoMapper = catalogoMapper;
        this.catalogoRepository = catalogoRepository;
    }

    // 🔎 Trova catalogo per nome
    public CatalogoDto findByNome(String nome) {
        return catalogoMapper.toDTO(
                catalogoRepository.findByNome(nome)
                        .orElseThrow(() -> new RuntimeException("Catalogo non trovato: " + nome))
        );
    }

    // 🔍 Controlla esistenza
    public boolean existsByNome(String nome) {
        return catalogoRepository.existsByNome(nome);
    }

    // 🔎 Contiene parola
    public List<CatalogoDto> findByNomeContaining(String nome) {
        return catalogoRepository.findByNomeContaining(nome)
                .stream()
                .map(catalogoMapper::toDTO)
                .toList();
    }

    // 🔎 Inizia con
    public List<CatalogoDto> findByNomeStartingWith(String nome) {
        return catalogoRepository.findByNomeStartingWith(nome)
                .stream()
                .map(catalogoMapper::toDTO)
                .toList();
    }

    // 🔎 Finisce con
    public List<CatalogoDto> findByNomeEndingWith(String nome) {
        return catalogoRepository.findByNomeEndingWith(nome)
                .stream()
                .map(catalogoMapper::toDTO)
                .toList();
    }

    // 📦 Cataloghi con categorie
    public List<CatalogoDto> findCataloghiConCategorie() {
        return catalogoRepository.findByCategorieIsNotNull()
                .stream()
                .map(catalogoMapper::toDTO)
                .toList();
    }

    // 📦 Cataloghi vuoti
    public List<CatalogoDto> findCataloghiSenzaCategorie() {
        return catalogoRepository.findByCategorieIsNull()
                .stream()
                .map(catalogoMapper::toDTO)
                .toList();
    }

    // 📊 Cataloghi con più di X categorie
    public List<CatalogoDto> findByNumeroCategorieGreaterThan(int size) {
        return catalogoRepository.findByCategorie_SizeGreaterThan(size)
                .stream()
                .map(catalogoMapper::toDTO)
                .toList();
    }
}