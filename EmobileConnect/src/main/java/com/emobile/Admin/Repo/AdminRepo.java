package com.emobile.Admin.Repo;

import com.emobile.User.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepo extends CrudRepository<User, Long> {
    @Query(value = "SELECT * FROM User u WHERE u.status = 'Approved'",
            nativeQuery = true)
    List<User> findByApproved();

}
