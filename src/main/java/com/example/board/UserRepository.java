package com.example.board;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.board.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
