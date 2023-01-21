/**
 * 
 */
package com.springboot.app.mynotes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.mynotes.Exceptions.ResourceNotFound;
import com.springboot.app.mynotes.Models.Note;
import com.springboot.app.mynotes.Repository.NoteBookRepository;

/**
 * @author SATYAM
 *
 */

@RestController
@RequestMapping("/api")
public class NoteBookController {

	@Autowired
	private NoteBookRepository NBR;
		
	@PostMapping("/notes")
	public Note createNote(@RequestBody Note note) {
		return NBR.save(note);
	}
	
	@GetMapping("/notes")
	public List<Note> getAllNotes(){
		return NBR.findAll();	
		}
 
	@GetMapping("/notes/{id}")
	public Note getNoteById(@PathVariable(value="id") Long noteId ) {
		return NBR.findById(noteId).orElseThrow(()-> new ResourceNotFound("Note","id",noteId));
	}
	
	@PutMapping("/notes/{id}")
	public Note updateNote(@PathVariable(value="id") Long noteId, @RequestBody Note noteDetails ) {
		 Note notes =  NBR.findById(noteId).orElseThrow(()-> new ResourceNotFound("Note","id",noteId));
		 notes.setTitle(noteDetails.getTitle());
		 notes.setContent(noteDetails.getContent());
		 Note updateNote =NBR.save(notes);
		 return updateNote;
	}

	@DeleteMapping("/notes/{id}")
	public ResponseEntity <?>deleteNote(@PathVariable(value="id") Long noteId) {
		 Note notes =  NBR.findById(noteId).orElseThrow(()-> new ResourceNotFound("Note","id",noteId));
		 
		 NBR.delete(notes);
		return ResponseEntity.ok().build() ;
	 
	}













}