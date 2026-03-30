package it.Gruppo.NerdMania.Mapper;


import it.Gruppo.NerdMania.DTO.UserDto;
import it.Gruppo.NerdMania.Modelli.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractConverter<User, UserDto> {

    final private ModelMapper mapper =  new ModelMapper();

    @Override
    public UserDto toDTO(User entity) {return mapper.map(entity, UserDto.class); }

    @Override
    public User toEntity(UserDto dto) {return mapper.map(dto, User.class); }
}
