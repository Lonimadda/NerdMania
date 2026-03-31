package it.Gruppo.NerdMania.Mapper;

import it.Gruppo.NerdMania.DTO.CarrelloDto;
import it.Gruppo.NerdMania.Modelli.Carrello;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component                        //LorenzoLombardi
public class CarrelloMapper extends AbstractConverter<Carrello, CarrelloDto> {


    //modelmapper usato per mappare automaticamente
    final private ModelMapper mapper = new ModelMapper();

    // converte entità Auto in DTO AutoDto
    @Override
    public CarrelloDto toDTO(Carrello entity) { return mapper.map(entity, CarrelloDto.class); }

    //converte DTO AutoDto in entità Auto
    @Override
    public Carrello toEntity(CarrelloDto dto) { return mapper.map(dto, Carrello.class);} }