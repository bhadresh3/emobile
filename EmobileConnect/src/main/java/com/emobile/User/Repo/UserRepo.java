package com.emobile.User.Repo;

import com.emobile.User.Model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {


}
