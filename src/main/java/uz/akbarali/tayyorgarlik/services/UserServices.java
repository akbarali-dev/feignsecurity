package uz.akbarali.tayyorgarlik.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.akbarali.tayyorgarlik.exception.ResourceNotFoundException;
import uz.akbarali.tayyorgarlik.exception.UserNotFoundException;
import uz.akbarali.tayyorgarlik.models.User;
import uz.akbarali.tayyorgarlik.reposioty.UserRepository;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public void deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found"));
        userRepository.delete(user);
    }

    public User updateUser(User user){
        User fUser = userRepository.findById(user.getId()).orElseThrow(() -> new ResourceNotFoundException("spring.datasource.username not found"));
        fUser.setFullName(user.getFullName());
        return userRepository.save(fUser);
    }
}
