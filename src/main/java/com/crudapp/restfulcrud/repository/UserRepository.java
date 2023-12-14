package com.crudapp.restfulcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudapp.restfulcrud.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
