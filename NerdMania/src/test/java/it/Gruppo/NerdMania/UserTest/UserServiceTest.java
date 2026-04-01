package it.Gruppo.NerdMania.UserTest;

import it.Gruppo.NerdMania.DTO.UserDto;
import it.Gruppo.NerdMania.Mapper.UserMapper;
import it.Gruppo.NerdMania.Modelli.User;
import it.Gruppo.NerdMania.Repository.UserRepository;
import it.Gruppo.NerdMania.Service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;
    @Mock
    private UserMapper userMapper;

    @Test
    void findByNomeContainingIgnoreCase_found() {
        User user = new User();
        user.setNome("Mario");
        UserDto userDto = new UserDto();
        userDto.setNome("Mario");

        List<User> list = List.of(user);
        List<UserDto> listDto = List.of(userDto);

        when(userRepository.findByNomeContainingIgnoreCase("Mario")).thenReturn(list);
        when(userMapper.toDTOList(list)).thenReturn(listDto);

        List<UserDto> result = userService.findByNomeContainingIgnoreCase("Mario");

        assertNotNull(result);
        assertEquals("Mario", result.get(0).getNome());
       verify(userRepository).findByNomeContainingIgnoreCase("Mario");
       verify(userMapper).toDTOList(list);

    }

    @Test
    void findByNomeContainingIgnoreCase_empty() {
        List<User> list = List.of();
        List<UserDto> listDto = List.of();

        when(userRepository.findByNomeContainingIgnoreCase("Mario")).thenReturn(list);
        when(userMapper.toDTOList(list)).thenReturn(listDto);

        List<UserDto> result = userService.findByNomeContainingIgnoreCase("Mario");

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(userRepository).findByNomeContainingIgnoreCase("Mario");
        verify(userMapper).toDTOList(list);
    }

    @Test
    void findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase_found() {
        User user = new User();
        user.setNome("Mario");
        user.setCognome("Rossi");
        UserDto userDto = new UserDto();
        userDto.setNome("Mario");
        userDto.setCognome("Rossi");

        List<User> list = List.of(user);
        List<UserDto> listDto = List.of(userDto);

        when(userRepository.findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase("Mario", "Rossi")).thenReturn(list);
        when(userMapper.toDTOList(list)).thenReturn(listDto);

        List<UserDto> result = userService.findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase("Mario", "Rossi");

        assertNotNull(result);
        assertEquals("Mario", result.get(0).getNome());
        assertEquals("Rossi", result.get(0).getCognome());
        verify(userRepository).findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase("Mario", "Rossi");
        verify(userMapper).toDTOList(list);
    }

    @Test
    void findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase_empty() {
        List<User> list = List.of();
        List<UserDto> listDto = List.of();

        when(userRepository.findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase("Mario", "Rossi")).thenReturn(list);
        when(userMapper.toDTOList(list)).thenReturn(listDto);

        List<UserDto> result = userService.findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase("Mario", "Rossi");

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(userRepository).findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase("Mario", "Rossi");
        verify(userMapper).toDTOList(list);
    }

    @Test
    void findByCognome_found() {
        User user = new User();
        user.setCognome("Rossi");
        UserDto userDto = new UserDto();
        userDto.setCognome("Rossi");

        List<User> list = List.of(user);
        List<UserDto> listDto = List.of(userDto);

        when(userRepository.findByCognome("Rossi")).thenReturn(list);
        when(userMapper.toDTOList(list)).thenReturn(listDto);

        List<UserDto> result = userService.findByCognome("Rossi");

        assertNotNull(result);
        assertEquals("Rossi", result.get(0).getCognome());
        verify(userRepository).findByCognome("Rossi");
        verify(userMapper).toDTOList(list);
    }

    @Test
    void findByCognome_empty() {
        List<User> list = List.of();
        List<UserDto> listDto = List.of();

        when(userRepository.findByCognome("Rossi")).thenReturn(list);
        when(userMapper.toDTOList(list)).thenReturn(listDto);

        List<UserDto> result = userService.findByCognome("Rossi");

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(userRepository).findByCognome("Rossi");
        verify(userMapper).toDTOList(list);
    }

    @Test
    void findByCartaFedeltaTrue() {
        User user = new User();
        user.setCartaFedelta(true);
        UserDto userDto = new UserDto();
        userDto.setCartaFedelta(true);

        List<User> list = List.of(user);
        List<UserDto> listDto = List.of(userDto);

        when(userRepository.findByCartaFedeltaTrue()).thenReturn(list);
        when(userMapper.toDTOList(list)).thenReturn(listDto);

        List<UserDto> result = userService.findByCartaFedeltaTrue();

        assertNotNull(result);
        assertTrue(result.getFirst().getCartaFedelta());
        verify(userRepository).findByCartaFedeltaTrue();
        verify(userMapper).toDTOList(list);
    }

    @Test
    void findByCartaFedeltaFalse(){
        User user = new User();
        user.setCartaFedelta(false);
        UserDto userDto = new UserDto();
        userDto.setCartaFedelta(false);

        List<User> list = List.of(user);
        List<UserDto> listDto = List.of(userDto);

        when(userRepository.findByCartaFedeltaTrue()).thenReturn(list);
        when(userMapper.toDTOList(list)).thenReturn(listDto);

        List<UserDto> result = userService.findByCartaFedeltaTrue();

        assertNotNull(result);
        assertFalse(result.getFirst().getCartaFedelta());
        verify(userRepository).findByCartaFedeltaTrue();
        verify(userMapper).toDTOList(list);
    }

    @Test
    void exiexistsByUsername_True(){
        User user = new User();
        user.setCognome("Rossi");
        UserDto userDto = new UserDto();
        userDto.setCognome("Rossi");

        List<User> list = List.of(user);
        List<UserDto> listDto = List.of(userDto);

        when(userRepository.existsByUsername("Rossi")).thenReturn(true);


        boolean result = userService.exiexistsByUsername("Rossi");

        assertTrue(result);

        verify(userRepository).existsByUsername("Rossi");

    }

    @Test
    void exiexistsByUsername_False(){
        List<User> list = List.of();
        List<UserDto> listDto = List.of();

        when(userRepository.existsByUsername("Rossi")).thenReturn(false);


        boolean result = userService.exiexistsByUsername("Rossi");


        assertFalse(result);
        verify(userRepository).existsByUsername("Rossi");

    }

    @Test
    void exiexistsByEmail_True(){
        User user = new User();
        user.setEmail("Rossi@gm");
        UserDto userDto = new UserDto();
        userDto.setEmail("Rossi@gm");

        List<User> list = List.of(user);
        List<UserDto> listDto = List.of(userDto);

        when(userRepository.existsByEmail("Rossi@gm")).thenReturn(true);


        boolean result =  userService.exiexistsByEmail("Rossi@gm");

        assertTrue(result);
        verify(userRepository).existsByEmail("Rossi@gm");

    }

    @Test
    void exiexistsByEmail_False(){
        List<User> list = List.of();
        List<UserDto> listDto = List.of();

        when(userRepository.existsByEmail("Rossi")).thenReturn(false);


        boolean result = userService.exiexistsByEmail("Rossi");

        assertFalse(result);
        verify(userRepository).existsByEmail("Rossi");

    }

   @Test
   void findAllByOrderByNomeAsc_found(){
        User user = new User();
        user.setNome("Rossi");
        UserDto userDto = new UserDto();
        userDto.setNome("Rossi");

        List<User> list = List.of(user);
        List<UserDto> listDto = List.of(userDto);

        when(userRepository.findAllByOrderByNomeAsc()).thenReturn(list);
        when(userMapper.toDTOList(list)).thenReturn(listDto);

        List<UserDto> result = userService.findAllByOrderByNomeAsc();

        assertNotNull(result);
        assertEquals(listDto, result);
        assertEquals("Rossi",  result.get(0).getNome());
        verify(userRepository).findAllByOrderByNomeAsc();
        verify(userMapper).toDTOList(list);
   }

   @Test
   void findAllByOrderByNomeAsc_empty(){
        List<User> list = List.of();
        List<UserDto> listDto = List.of();

        when(userRepository.findAllByOrderByNomeAsc()).thenReturn(list);
        when(userMapper.toDTOList(list)).thenReturn(listDto);
        List<UserDto> result = userService.findAllByOrderByNomeAsc();

        assertNotNull(result);
        assertEquals(listDto, result);
        verify(userRepository).findAllByOrderByNomeAsc();
        verify(userMapper).toDTOList(list);
   }

   @Test
   void findAllByOrderByCognomeAsc_found(){
        User user = new User();
        user.setCognome("Rossi");
        UserDto userDto = new UserDto();
        userDto.setCognome("Rossi");

        List<User> list = List.of(user);
        List<UserDto> listDto = List.of(userDto);

        when(userRepository.findAllByOrderByCognomeAsc()).thenReturn(list);
        when(userMapper.toDTOList(list)).thenReturn(listDto);

        List<UserDto> result = userService.findAllByOrderByCognomeAsc();

        assertNotNull(result);
        assertEquals(listDto, result);
        verify(userRepository).findAllByOrderByCognomeAsc();
        verify(userMapper).toDTOList(list);
   }

   @Test
   void findAllByOrderByCognomeAsc_empty(){
       List<User> list = List.of();
       List<UserDto> listDto = List.of();

       when(userRepository.findAllByOrderByCognomeAsc()).thenReturn(list);
       when(userMapper.toDTOList(list)).thenReturn(listDto);

       List<UserDto> result = userService.findAllByOrderByCognomeAsc();

       assertNotNull(result);
       assertEquals(listDto, result);
       verify(userRepository).findAllByOrderByCognomeAsc();
       verify(userMapper).toDTOList(list);

   }

}
