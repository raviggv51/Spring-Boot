package projectByRavi.journalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectByRavi.journalProject.entity.Journal;
import projectByRavi.journalProject.entity.User;
import projectByRavi.journalProject.service.JournalEntryService;
import projectByRavi.journalProject.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return  userService.getAll();

    }
    @PostMapping
    public void AddUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PutMapping("/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String userName){
        User userInDB = userService.findByUserName(userName);
        if(userInDB!=null){
            userInDB.setUserName(user.getUserName());
            userInDB.setPassword(user.getPassword());
            userService.saveUser(userInDB);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("{Id}")
    public void deleteUser(@PathVariable String Id)
    {
        userService.deleteById(Id);

    }
}
