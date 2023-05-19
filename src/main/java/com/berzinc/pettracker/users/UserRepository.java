package com.berzinc.pettracker.users;

import org.springframework.data.jpa.repository.JpaRepository;

/**		
 * 
 * @author Erik Ziegler
 *
 */

public interface UserRepository extends JpaRepository<User, Long> {

}
