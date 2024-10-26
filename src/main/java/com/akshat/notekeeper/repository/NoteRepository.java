package com.akshat.notekeeper.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.akshat.notekeeper.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}