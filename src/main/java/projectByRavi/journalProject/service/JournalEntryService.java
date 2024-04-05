package projectByRavi.journalProject.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import projectByRavi.journalProject.entity.Journal;
import projectByRavi.journalProject.entity.User;
import projectByRavi.journalProject.respository.JournalEntryRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void saveJournal(Journal myJournal, String userName){
        try{
            myJournal.setDate(LocalDateTime.now());
            Journal saved = journalEntryRepository.save(myJournal);
            User user= userService.findByUserName(userName);
            user.getJournalEntries().add(saved);
            user.setUserName(null);
            userService.saveUser(user);
        } catch(Exception e){
            log.error("Expcetion", e);
            throw new RuntimeException("An error occured",e);
        }
    }
    public void saveJournal(Journal myJournal){
        journalEntryRepository.save(myJournal);
    }
    public List<Journal> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<Journal> findById(String id){
        return journalEntryRepository.findById(id);
    }
    public void deleteById(String id){
        journalEntryRepository.deleteById(id);
    }

}
