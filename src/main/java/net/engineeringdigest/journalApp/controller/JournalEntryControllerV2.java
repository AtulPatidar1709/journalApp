package net.engineeringdigest.journalApp.controller;


import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
@CrossOrigin
public class JournalEntryControllerV2 {

//    private Map<Long , JournalEntry> journalEntries = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getAll() {
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myEntry){
//        journalEntries.put(myEntry.getId(), myEntry);
//        return true;
//    }
//
//    @GetMapping("id/{myId}")
//    public JournalEntry getJournalEntryById(@PathVariable Long myId){
//        return journalEntries.get(myId);
//    }
//
//    @DeleteMapping("id/{myId}")
//    public boolean deleteJournalEntryById(@PathVariable Long myId){
//        journalEntries.remove(myId);
//        return true;
//    }
//
//    @PutMapping("id/{id}")
//    public JournalEntry updateJournalById(@PathVariable Long id, @RequestBody JournalEntry myEntry){
//        return journalEntries.put(id, myEntry);
//    }
}
