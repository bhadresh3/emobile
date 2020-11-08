package com.emobile.Admin.Service;

import com.emobile.Admin.Repo.AdminRepo;
import com.emobile.User.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{
    private AdminRepo adminRepo;

    @Autowired
    public AdminServiceImpl(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public void postStatus(String requestId, String newStatus)
    {
       long id = Long.parseLong(requestId);
        Optional<User> currentUser = adminRepo.findById(id);
        if(currentUser.isPresent()){
            User user = currentUser.get();
            user.setStatus(newStatus);
            adminRepo.save(user);
        }
    }

    @Override
    public List<User> findByApproved() {
        return adminRepo.findByApproved();
    }

    @Override
    public void save(User user) {
        adminRepo.save(user);
    }

}
