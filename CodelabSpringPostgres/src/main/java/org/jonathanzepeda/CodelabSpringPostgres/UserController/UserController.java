package org.jonathanzepeda.CodelabSpringPostgres.UserController;


import org.jonathanzepeda.CodelabSpringPostgres.UserDto;
import org.jonathanzepeda.CodelabSpringPostgres.UserNotFoundException;
import org.jonathanzepeda.CodelabSpringPostgres.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.jonathanzepeda.CodelabSpringPostgres.User;
import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User createUser(@RequestBody UserDto userDto) {
        User newUser = new User(userDto);
        return userRepository.save(newUser);
    }

    @GetMapping("/{id}")
    User findById(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent())
            return optionalUser.get();
        else throw new UserNotFoundException();
    }

}