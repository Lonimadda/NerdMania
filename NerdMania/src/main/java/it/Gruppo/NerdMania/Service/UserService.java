package it.Gruppo.NerdMania.Service;

import it.Gruppo.NerdMania.DTO.UserDto;
import it.Gruppo.NerdMania.Mapper.Converter;
import it.Gruppo.NerdMania.Mapper.UserMapper;
import it.Gruppo.NerdMania.Modelli.User;
import it.Gruppo.NerdMania.Repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends AbstractService<User, UserDto>{

private final UserMapper userMapper;

private final UserRepository userRepository;

    public UserService(JpaRepository<User, Integer> repository, Converter<User, UserDto> converter, UserMapper userMapper, UserRepository userRepository) {
        super(repository, converter);
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public List<UserDto> findfindByNomeContainingIgnoreCase(String nome) {
        return userMapper.toDTOList(userRepository.findByNomeContainingIgnoreCase(nome));
    }

    public List<UserDto> findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase(String nome, String cognome) {
        return userMapper.toDTOList(userRepository.findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase(nome, cognome));
    }

    public List<UserDto> findByCognome(String cognome) {
        return userMapper.toDTOList(userRepository.findByCognome(cognome));
    }

    public List<UserDto> findByCartaFedeltaTrue(){
        return userMapper.toDTOList(userRepository.findByCartaFedeltaTrue());
    }

    public List<UserDto> findByCartaFedeltaFalse(){
        return userMapper.toDTOList(userRepository.findByCartaFedeltaFalse());
    }

    public boolean exiexistsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean exiexistsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public List<UserDto> findAllByOrderByNomeAsc(){
        return userMapper.toDTOList(userRepository.findAllByOrderByNomeAsc());
    }

    public List<UserDto> findAllByOrderByCognomeAsc(){
        return userMapper.toDTOList(userRepository.findAllByOrderByCognomeAsc());
    }

}
