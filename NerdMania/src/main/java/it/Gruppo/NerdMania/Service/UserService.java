package it.Gruppo.NerdMania.Service;

import it.Gruppo.NerdMania.DTO.UserDto;
import it.Gruppo.NerdMania.Mapper.Converter;
import it.Gruppo.NerdMania.Mapper.UserMapper;
import it.Gruppo.NerdMania.Modelli.User;
import org.springframework.data.jpa.repository.JpaRepository;

public class UserService extends AbstractService<User, UserDto>{

private final UserMapper userMapper;

private final UserRepository userRepository;

    public UserService(JpaRepository<User, Integer> repository, Converter<User, UserDto> converter, UserMapper userMapper, UserRepository userRepository) {
        super(repository, converter);
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    



}
