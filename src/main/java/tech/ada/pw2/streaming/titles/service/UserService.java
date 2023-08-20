package tech.ada.pw2.streaming.titles.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.ada.pw2.streaming.titles.dto.NewUserDTO;
import tech.ada.pw2.streaming.titles.dto.UserDTO;
import tech.ada.pw2.streaming.titles.dto.parser.UserDTOParser;
import tech.ada.pw2.streaming.titles.exception.DataNotFoundException;
import tech.ada.pw2.streaming.titles.model.User;
import tech.ada.pw2.streaming.titles.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserDTOParser::parse)
                .toList();
    }

    public UserDTO getUser(Long id) {
        return UserDTOParser.parse(userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(
                        String.format("Usuário não encontrado com id: %s", id))));
    }

    public UserDTO save(NewUserDTO user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return UserDTOParser.parse(userRepository.save(UserDTOParser.toUser(user)));
    }

    public UserDTO update(NewUserDTO userUpdated, Long id) {
        getUser(id);
        User user = UserDTOParser.toUser(userUpdated);
        user.setId(id);

        return UserDTOParser.parse(userRepository.save(user));
    }

    public void delete(Long id) {
        getUser(id);
        userRepository.deleteById(id);
    }
}
