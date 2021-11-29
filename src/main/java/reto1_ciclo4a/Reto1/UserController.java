package reto1_ciclo4a.Reto1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User singIn(@RequestBody User user) {
        return userService.SignIn(user);
    }

    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email") String email) {
        return userService.existEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public User userAuthenticate(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.userAuthenticate(email, password);
    }
}
