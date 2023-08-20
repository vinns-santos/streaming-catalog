package tech.ada.pw2.streaming.titles.dto.parser;

import tech.ada.pw2.streaming.titles.dto.NewUserDTO;
import tech.ada.pw2.streaming.titles.dto.UserDTO;
import tech.ada.pw2.streaming.titles.model.User;

public class UserDTOParser {

    public static UserDTO parse(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setCpf(user.getCpf());
        userDTO.setLogin(user.getLogin());
        userDTO.setName(user.getName());
        return userDTO;
    }

    public static User toUser(NewUserDTO dto) {
        User user = new User();
        user.setCpf(dto.getCpf());
        user.setLogin(dto.getLogin());
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        return user;
    }
}
