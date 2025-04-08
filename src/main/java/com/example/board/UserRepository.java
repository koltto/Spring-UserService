
package com.example.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.board.User;

/*import org.springframework.data.jpa.repository.JpaRepository; 
  
 * 
 * public interface UserRepository extends JpaRepository<User, Long> {
 * 
 * }
 */

@Repository
public class UserRepository {
	private Map<Long, User> users = new HashMap<>();
	private Long id = 0L;
	
	public void save(User user) {
		user.setId(++id);
		users.put(id, user);
	}
	
	public User getUser(Long id) {
		return users.get(id);
	}
}