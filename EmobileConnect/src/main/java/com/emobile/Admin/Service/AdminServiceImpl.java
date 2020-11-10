package com.emobile.Admin.Service;

import com.emobile.Admin.Repo.AdminRepo;
import com.emobile.Exception.Admin.InvalidRequestIdException;
import com.emobile.Exception.Admin.WrongStatusException;
import com.emobile.User.Model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{
    private AdminRepo adminRepo;
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    public AdminServiceImpl(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public void postStatus(String requestId, String newStatus)
    {
        LOGGER.info("Change status request called for {} with status {}", requestId, newStatus);
        if(newStatus.equals("unidentified")){
            throw new WrongStatusException("Request status is not valid");
        }
       long id = Long.parseLong(requestId);
        Optional<User> currentUser = adminRepo.findById(id);
        if(currentUser.isPresent()){
            User user = currentUser.get();
            user.setStatus(newStatus);
            adminRepo.save(user);
        }else{
            LOGGER.info("No user available with request id {}", requestId);
            throw new InvalidRequestIdException("Request Id is invalid");
        }
    }

    @Override
    public List<User> findByApproved() {
        LOGGER.info("Find Approved request called");
        return adminRepo.findByApproved();
    }

    @Override
    public void save(User user) {
        LOGGER.info("Save user request");
        adminRepo.save(user);
    }

}
