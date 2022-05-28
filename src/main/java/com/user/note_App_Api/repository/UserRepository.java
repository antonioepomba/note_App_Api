/**
 * 
 */
package com.user.note_App_Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.note_App_Api.model.Users;

/**
 * @author antonio.epomba
 *
 */
@Repository
public interface UserRepository extends  JpaRepository<Users,Long> {
	
	Users  findById(long id);
	Users  deleteById(long id);
}
