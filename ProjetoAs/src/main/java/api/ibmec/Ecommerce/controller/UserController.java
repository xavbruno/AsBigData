
package api.ibmec.Ecommerce.controller;

import api.ibmec.Ecommerce.dto.UserWithPlaylistsDTO;
import api.ibmec.Ecommerce.entity.User;
import api.ibmec.Ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<UserWithPlaylistsDTO> getUserWithPlaylists(@PathVariable String cpf) {
        UserWithPlaylistsDTO userWithPlaylists = userService.getUserWithPlaylists(cpf);

        if (userWithPlaylists == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userWithPlaylists);
    }
}
