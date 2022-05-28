/**
 * 
 */
package com.user.note_App_Api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.note_App_Api.model.Note;
import com.user.note_App_Api.model.Note;
/**
 * @author antonio.epomba
 *
 */
@Repository
public interface NoteRepository  extends JpaRepository <Note,Long>{
	Optional<Note> findById(long id);
	Note deleteById(long id);
}
