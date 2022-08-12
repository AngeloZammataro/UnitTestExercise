package co.develhope.testController.controller;

import co.develhope.testController.entities.User;
import co.develhope.testController.repositories.UserRepository;
import co.develhope.testController.services.UserService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    //CREATE user
    @PostMapping("")
    public @ResponseBody User create(@RequestBody User user){
        return userRepository.save(user);
    }

    //READ all users
    @GetMapping("/")
    public @ResponseBody List<User> getList(){
        return userRepository.findAll();
    }

    //READ single user
    @GetMapping("/{id}")
    public @ResponseBody User getSingle(@PathVariable long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    //UPDATE single user
    @PutMapping("/{id}")
    public @ResponseBody User update(@PathVariable long id,@RequestBody @NotNull User user){
        user.setId(id);
        return userRepository.save(user);
    }

    //UPDATE single user
    @PutMapping("/{id}/activation")
    public @ResponseBody User setUserActive(@PathVariable long id, @RequestParam("activated") boolean activated){
        return userService.setUserActivationStatus(id,activated);
    }

    //DELET all
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        userRepository.deleteById(id);
    }


}
