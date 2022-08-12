package co.develhope.testController.services;

import co.develhope.testController.entities.User;
import co.develhope.testController.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User setUserActivationStatus(Long userId, boolean isActive){
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()) return null;
        user.get().setActive(isActive);
        return userRepository.save(user.get());
    }
}
