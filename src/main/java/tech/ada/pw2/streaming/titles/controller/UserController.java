package tech.ada.pw2.streaming.titles.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.ada.pw2.streaming.titles.dto.NewUserDTO;
import tech.ada.pw2.streaming.titles.dto.UserDTO;
import tech.ada.pw2.streaming.titles.service.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(service.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.getUser(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> signup(@RequestBody @Valid NewUserDTO newUserDTO) {
        UserDTO userDTO = service.save(newUserDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(userDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody NewUserDTO user, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(user, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
