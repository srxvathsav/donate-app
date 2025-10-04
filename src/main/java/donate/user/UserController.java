package donate.user;
import donate.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public User createUser(@RequestBody User user) {
        userService.createUser(user);
        return user;
    }

}
