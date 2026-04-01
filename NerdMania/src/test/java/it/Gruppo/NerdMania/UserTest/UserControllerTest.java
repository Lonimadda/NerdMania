package it.Gruppo.NerdMania.UserTest;

import it.Gruppo.NerdMania.Controller.UserController;
import it.Gruppo.NerdMania.DTO.UserDto;
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
public class UserControllerTest {

    @Mock
    private UserService  userService;
    @InjectMocks
    private UserController userController;

    @Test
    void findByNomeContainingIgnoreCase_found(){
        UserDto userDto = new UserDto();
        userDto.setNome("Mario");
        UserDto userDto1 = new UserDto();
        userDto1.setNome("Marco");
        List<UserDto> userDtos = List.of(userDto, userDto1);

        when(userService.findByNomeContainingIgnoreCase("ma")).thenReturn(userDtos);

        List<UserDto> result = userController.findByNomeContainingIgnoreCase("ma");

        assertNotNull(result);
        assertEquals("Mario",result.get(0).getNome());
        assertEquals("Marco",result.get(1).getNome());
        verify(userService).findByNomeContainingIgnoreCase("ma");
    }

    @Test
    void findByNomeContainingIgnoreCase_empty(){
        List<UserDto> userDtos = List.of();

        when(userService.findByNomeContainingIgnoreCase("xyz")).thenReturn(userDtos);

        List<UserDto> result = userController.findByNomeContainingIgnoreCase("xyz");
        assertNotNull(result);
        assertEquals(0,result.size());
        verify(userService).findByNomeContainingIgnoreCase("xyz");
    }

    @Test
    void findByNomeContainingIgnoreCase_null(){
        List<UserDto> userDtos = List.of();
        when(userService.findByNomeContainingIgnoreCase(null)).thenReturn(userDtos);
        List<UserDto> result = userController.findByNomeContainingIgnoreCase(null);
        assertNotNull(result);
        assertEquals(0,result.size());
        verify(userService).findByNomeContainingIgnoreCase(null);
    }

    @Test
    void findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase_found() {
        UserDto userDto = new UserDto();
        userDto.setNome("Mario");
        userDto.setCognome("Rossi");

        List<UserDto> userDtos = List.of(userDto);

        when(userService.findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase("Mario","Rossi")).thenReturn(userDtos);

        List<UserDto> result = userController.findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase("Mario",  "Rossi");

        assertNotNull(result);
        assertEquals("Mario",result.getFirst().getNome());
        assertEquals("Rossi",result.getFirst().getCognome());
        verify(userService).findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase("Mario","Rossi");
    }

    @Test
    void findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase_empty() {
        when(userService.findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase("xyz","abc")).thenReturn(List.of());

        List<UserDto> result = userController.findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase("xyz","abc");
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(userService).findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase("xyz","abc");
    }

    @Test
    void findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase_null() {
        when(userService.findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase(null, null)).thenReturn(List.of());

        List<UserDto> result = userController.findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase(null, null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(userService).findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase(null, null);
    }

    @Test
    void findByCognome_found(){
        UserDto userDto = new UserDto();
        userDto.setCognome("Rossi");
        List<UserDto> userDtos = List.of(userDto);

        when(userService.findByCognome("Rossi")).thenReturn(userDtos);
        List<UserDto> result = userController.findByCognome("Rossi");

        assertNotNull(result);
        assertEquals("Rossi",result.getFirst().getCognome());
        verify(userService).findByCognome("Rossi");
    }

    @Test
    void findByCognome_empty(){
        when(userService.findByCognome("xyz")).thenReturn(List.of());

        List<UserDto> result = userController.findByCognome("xyz");
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(userService).findByCognome("xyz");
    }

    @Test
    void findByCognome_null(){
        when(userService.findByCognome(null)).thenReturn(List.of());
        List<UserDto> result = userController.findByCognome(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(userService).findByCognome(null);
    }

    @Test
    void findByCartaFedeltaTrue(){
        UserDto user1 = new UserDto();
        user1.setNome("Mario");
        user1.setCognome("Rossi");
        user1.setCartaFedelta(true);

        UserDto user2 = new UserDto();
        user2.setNome("Marco");
        user2.setCognome("Verdi");
        user2.setCartaFedelta(true);

        List<UserDto> userDtos = List.of(user1, user2);

        // Mock del service
        when(userService.findByCartaFedeltaTrue())
                .thenReturn(userDtos);

        // Chiamata al controller
        List<UserDto> result = userController.findByCartaFedeltaTrue();

        // Asserzioni
        assertNotNull(result);
        assertEquals(2, result.size());

        assertTrue(result.get(0).getCartaFedelta());
        assertTrue(result.get(1).getCartaFedelta());

        // Verifica che il service sia stato chiamato
        verify(userService).findByCartaFedeltaTrue();
    }

    @Test
    void findByCartaFedeltaTrue_empty(){
        when(userService.findByCartaFedeltaTrue()).thenReturn(List.of());

        List<UserDto> result = userController.findByCartaFedeltaTrue();
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(userService).findByCartaFedeltaTrue();
    }

    @Test
    void findByCartaFedeltaFalse(){
        UserDto user1 = new UserDto();
        user1.setNome("Mario");
        user1.setCognome("Rossi");
        user1.setCartaFedelta(false);

        List<UserDto> userDtos = List.of(user1);

        when(userService.findByCartaFedeltaFalse()).thenReturn(userDtos);

        List<UserDto> result = userController.findByCartaFedeltaFalse();
        assertNotNull(result);
        assertFalse(result.getFirst().getCartaFedelta());
        verify(userService).findByCartaFedeltaFalse();
    }

    @Test
    void exiexistsByUsername_true(){
        UserDto user1 = new UserDto();
        user1.setUsername("Rossi");

        when(userService.exiexistsByUsername("Rossi")).thenReturn(true);

        boolean result = userController.exiexistsByUsername("Rossi");
        assertTrue(result);
        verify(userService).exiexistsByUsername("Rossi");
    }

    @Test
    void exiexistsByUsername_false(){
        UserDto user1 = new UserDto();
        user1.setUsername("xyz");
        when(userService.exiexistsByUsername("xyz")).thenReturn(false);
        boolean result = userController.exiexistsByUsername("xyz");
        assertFalse(result);
        verify(userService).exiexistsByUsername("xyz");
    }

    @Test
    void exiexistsByEmail_True(){
        UserDto user1 = new UserDto();
        user1.setEmail("Rossi@gm");
        when(userService.exiexistsByEmail("Rossi@gm")).thenReturn(true);

        boolean result = userController.exiexistsByEmail("Rossi@gm");
        assertTrue(result);
        verify(userService).exiexistsByEmail("Rossi@gm");
    }

    @Test
    void exiexistsByEmail_False(){
        UserDto user1 = new UserDto();
        user1.setEmail("xyz@gm");
        when(userService.exiexistsByEmail("xyz@gm")).thenReturn(false);
        boolean result = userController.exiexistsByEmail("xyz@gm");

        assertFalse(result);
        verify(userService).exiexistsByEmail("xyz@gm");
    }

    @Test
    void findAllByOrderByNomeAsc_found(){
        UserDto user1 = new UserDto();
        user1.setNome("Mario");
        UserDto user2 = new UserDto();
        user2.setNome("Marco");

        List<UserDto> userDtos = List.of(user1, user2);
        when(userService.findAllByOrderByNomeAsc()).thenReturn(userDtos);
        List<UserDto> result = userController.findAllByOrderByNomeAsc();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(user1.getNome(), result.get(0).getNome());
        assertEquals(user2.getNome(), result.get(1).getNome());
        verify(userService).findAllByOrderByNomeAsc();
    }

    @Test
    void findAllByOrderByNomeAsc_empty(){
        UserDto user1 = new UserDto();
        user1.setNome("xyz");
        List<UserDto> userDtos = List.of(user1);
        when(userService.findAllByOrderByNomeAsc()).thenReturn(List.of());
        List<UserDto> result = userController.findAllByOrderByNomeAsc();
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(userService).findAllByOrderByNomeAsc();
    }

    @Test
    void findAllByOrderByNomeAsc_null(){
        List<UserDto> userDtos = List.of();
        when(userService.findAllByOrderByNomeAsc()).thenReturn(userDtos);
        List<UserDto> result = userController.findAllByOrderByNomeAsc();
        assertNotNull(result);
        assertEquals(userDtos, result);
        verify(userService).findAllByOrderByNomeAsc();
    }

    @Test
    void findAllByOrderByCognomeAsc_found(){
        UserDto user1 = new UserDto();
        user1.setCognome("Rossi");
        List<UserDto> userDtos = List.of(user1);
        when(userService.findAllByOrderByCognomeAsc()).thenReturn(userDtos);
        List<UserDto> result = userController.findAllByOrderByCognomeAsc();

        assertNotNull(result);
        assertEquals(userDtos, result);
        verify(userService).findAllByOrderByCognomeAsc();

    }

    @Test
    void findAllByOrderByCognomeAsc_empty(){
        List<UserDto> userDtos = List.of();
        when(userService.findAllByOrderByCognomeAsc()).thenReturn(userDtos);
        List<UserDto> result = userController.findAllByOrderByCognomeAsc();
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(userService).findAllByOrderByCognomeAsc();
    }
    @Test
    void findAllByOrderByCognomeAsc_null(){
        List<UserDto> userDtos = List.of();
        when(userService.findAllByOrderByCognomeAsc()).thenReturn(userDtos);
        List<UserDto> result = userController.findAllByOrderByCognomeAsc();
        assertNotNull(result);
        assertEquals(userDtos, result);
        verify(userService).findAllByOrderByCognomeAsc();
    }
}
