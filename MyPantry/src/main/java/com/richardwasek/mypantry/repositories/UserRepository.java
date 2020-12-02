package com.richardwasek.mypantry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.richardwasek.mypantry.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
