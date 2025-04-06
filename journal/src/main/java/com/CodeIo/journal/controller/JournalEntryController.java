package com.CodeIo.journal.controller;

import com.CodeIo.journal.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    HashMap<Long,JournalEntry> journalEntry= new HashMap<>();
    @GetMapping //@GetMapping("/data")
   public List<JournalEntry> getAll(){
       return new ArrayList<>(journalEntry.values());
   }
   @PostMapping
   public   boolean  createJournalEntry(@RequestBody JournalEntry entry){
        journalEntry.put(entry.getId(), entry);
        return true;
   }
   @GetMapping("/id/{myId}")
   public JournalEntry getJournalEntryById(@PathVariable long myId){
        return journalEntry.get(myId);
   }
    @DeleteMapping("/id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable long myId){
        return  journalEntry.remove(myId);
    }
    @PutMapping("/id/{myId}")
    public String updateJournalEntryById(@PathVariable long myId, @RequestBody JournalEntry entry){
        boolean key= journalEntry.keySet().contains(myId);
        if(key==true) {
            journalEntry.put(entry.getId(), entry);
        return "OK";
        }
        else
            return "Not found";

    }
}
