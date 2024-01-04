package com.LoginGrupp3.LoginGrupp3.repository;

import org.springframework.data.repository.CrudRepository;

import com.LoginGrupp3.LoginGrupp3.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}