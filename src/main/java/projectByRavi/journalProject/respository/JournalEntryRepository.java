package projectByRavi.journalProject.respository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import projectByRavi.journalProject.entity.Journal;

public interface JournalEntryRepository extends  MongoRepository<Journal, String>  {
}
