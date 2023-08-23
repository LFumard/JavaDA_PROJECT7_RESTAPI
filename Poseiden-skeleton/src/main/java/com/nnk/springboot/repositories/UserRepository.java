package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


//public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByusername(String username);

    //Optional<User> findByEmail(String username);
    //Optional<User> findByUserName(String username);
}
