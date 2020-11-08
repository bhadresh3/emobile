package com.emobile.Admin.Service;

import com.emobile.Admin.Repo.AdminRepo;
import com.emobile.User.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {


     void postStatus(String requestId, String newStatus);

     List<User> findByApproved();

    void save(User user);
}
