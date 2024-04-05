package projectByRavi.journalProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import projectByRavi.journalProject.entity.User;
import projectByRavi.journalProject.respository.UserRepository;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private  UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(String Id){
        return userRepository.findById(Id);
    }

    public void deleteById(String Id){
        userRepository.deleteById(Id);
    }
    public  User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
}
