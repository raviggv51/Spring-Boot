package projectByRavi.journalProject.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import projectByRavi.journalProject.entity.User;

public interface UserRepository extends MongoRepository<User,String> {
    User findByUserName(String username);
}
