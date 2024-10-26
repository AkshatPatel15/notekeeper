package com.akshat.notekeeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.akshat.notekeeper.model.Note;
import com.akshat.notekeeper.service.NoteService;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/v1/getallnotes")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/v1/getnote/{id}")
    public Note getNoteById(@PathVariable Long id) {
        Optional<Note> note = noteService.getNoteById(id);
        return note.orElse(null);
    }

    @PostMapping("/api/v1/savenote")
    public String saveNote(@RequestBody Note note) {
        Note savedNote = noteService.saveNote(note);
        return "Note saved with id: " + savedNote.getId();
    }

    @PutMapping("/v1/updatenote/{id}")
    public String updateNote(@PathVariable Long id, @RequestBody Note noteDetails) {
        Note updatedNote = noteService.updateNote(id, noteDetails);
        if (updatedNote != null) {
            return "Note updated with id: " + updatedNote.getId();
        } else {
            return "Note not found with id: " + id;
        }
    }

    @DeleteMapping("/v1/deletenote/{id}")
    public String deleteNoteById(@PathVariable Long id) {
        if (noteService.deleteNoteById(id)) {
            return "Note deleted with id: " + id;
        } else {
            return "Note not found with id: " + id;
        }
    }

    @DeleteMapping("/v1/deleteallnotes")
    public String deleteAllNotes() {
        noteService.deleteAllNotes();
        return "All notes deleted";
    }
}