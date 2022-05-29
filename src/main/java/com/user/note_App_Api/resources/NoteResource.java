package com.user.note_App_Api.resources;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.note_App_Api.model.Note;
import com.user.note_App_Api.model.Users;
import com.user.note_App_Api.repository.NoteRepository;
import com.user.note_App_Api.repository.UserRepository;


@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(value = "/api")
public class NoteResource {
	@Autowired
	NoteRepository noteRepository;
	
	@PostMapping("/note")
	public Note saveNote(@RequestBody Note notes) {
		 return noteRepository.save(notes);
	 }
	@CrossOrigin(origins = "http://localhost:8080")
	 @GetMapping("/notes")
	 @ResponseBody
	 public  List<Note> getAllNotes(){
		 return noteRepository.findAll();
	 }
	 
	 @GetMapping("/note/{id}")
	 @ResponseBody
	 public Optional<Note> getNoteById(@PathVariable("id") Long id){
		 return noteRepository.findById(id);
	 }
	 @CrossOrigin(origins = "http://localhost:8080")
	 @DeleteMapping("/note")
	public void deleteNotes(@RequestBody Note notes) {
		noteRepository.delete(notes);
	 }
	 @CrossOrigin(origins = "http://localhost:8080")
	 @PutMapping("/note")
	public void updateNote(@RequestBody Note notes) {
		 noteRepository.save(notes);
	 }
	  
}
