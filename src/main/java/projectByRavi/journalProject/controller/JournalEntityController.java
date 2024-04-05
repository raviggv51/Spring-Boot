//package projectByRavi.journalProject.controller;
//
//import org.springframework.web.bind.annotation.*;
//import projectByRavi.journalProject.entity.Journal;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/journal")
//class JournalEntityController {
//    private Map<Long, Journal> journalEntries = new HashMap<>();
//
//    @GetMapping
//    List<Journal> getAll(){
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody Journal myEntry){
//        journalEntries.put(myEntry.getId(),myEntry);
//        return true;
//    }
//
//
//    @GetMapping("{myId}")
//    public Journal getJournalEntryById(@PathVariable Long myId){
//       return  journalEntries.get(myId);
//    }
//
//    @DeleteMapping("/{myId}")
//    public boolean deleteJournalById(@PathVariable Long myId){
//        journalEntries.remove(myId);
//        return true;
//    }
//
//    @PutMapping("{myId}")
//    public boolean updateJournal(@PathVariable Long myId,@RequestBody Journal myEntry)
//    {
//        journalEntries.put(myId,myEntry);
//        return true;
//    }
//}
