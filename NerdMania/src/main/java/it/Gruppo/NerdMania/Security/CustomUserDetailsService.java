package it.Gruppo.NerdMania.Security;

import it.Gruppo.NerdMania.Modelli.User;
import it.Gruppo.NerdMania.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.
                findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User non trovato")
                );
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRuolo().toString())
                .build();
        //return new CustomUserDetails(user);
    }
}
