package tech.ada.pw2.streaming.titles.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.ada.pw2.streaming.titles.dto.UserDetailsInfo;
import tech.ada.pw2.streaming.titles.model.User;
import tech.ada.pw2.streaming.titles.repository.UserRepository;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    public UserDetailServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = repository.findByLogin(username);
        return new UserDetailsInfo(optionalUser.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado")));
    }
}
