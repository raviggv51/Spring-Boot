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
@RequestMapping("/journal")
public class JournalEntryControllerV2  {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Journal>> getall()
    {
        return new ResponseEntity<>(journalEntryService.getAll(),HttpStatus.OK);
    }

    @GetMapping("{userName}")
    public ResponseEntity<?> getAllJournalEntryOfUser(@PathVariable String userName){
        User user = userService.findByUserName(userName);
        List<Journal> all= user.getJournalEntries();
        if(all!=null && !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
//    @GetMapping
//    public ResponseEntity<?> getAllJournal(){
//        return new ResponseEntity<>(journalEntryService.getAll(),HttpStatus.OK);
//    }

    @PostMapping("{userName}")
    public ResponseEntity<Journal> createEntry(@RequestBody Journal myEntry,@PathVariable String userName){
        try{
            journalEntryService.saveJournal(myEntry,userName);
            return new ResponseEntity<>(myEntry,HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("id/{myId}")
    public ResponseEntity<Journal> getJournalEntryById(@PathVariable String myId){
        Optional<Journal> journalEntry = journalEntryService.findById(myId);
        if(journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteJournalById(@PathVariable String myId){
        try{
            journalEntryService.deleteById(myId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("id/{userName}/{myId}")
    public ResponseEntity<Journal> updateJournal(@PathVariable String myId,
                                                 @RequestBody Journal newE,
                                                 @PathVariable String userName)
    {
        Journal old = journalEntryService.findById(myId).orElse(null);
        if(old!=null){
            old.setContext(newE.getContext()!=null && !newE.getContext().equals("")?newE.getContext(): old.getContext());
            old.setDescription(newE.getDescription()!=null && !newE.getDescription().equals("")?newE.getDescription():old.getDescription());
            journalEntryService.saveJournal(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
