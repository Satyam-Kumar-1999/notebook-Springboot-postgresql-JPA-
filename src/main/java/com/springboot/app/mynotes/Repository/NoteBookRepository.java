/**
 * 
 */
package com.springboot.app.mynotes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.mynotes.Models.Note;

/**
 * @author SATYAM
 *
 */
public interface NoteBookRepository extends JpaRepository<Note, Long> {

}
