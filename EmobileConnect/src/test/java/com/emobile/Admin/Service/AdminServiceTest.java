package com.emobile.Admin.Service;

import com.emobile.Admin.Repo.AdminRepo;
import com.emobile.User.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class AdminServiceTest {

    @InjectMocks
    private AdminServiceTest adminService;

    @Mock
    private AdminRepo adminRepo;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("When post status metod call it will change status")
    void postStatus(){
        AdminServiceImpl adminServiceImpl = new AdminServiceImpl(adminRepo);
        User user = new User();
        when(adminRepo.save(user)).thenReturn(null);
        adminServiceImpl.postStatus("1234", "APPROVED");
        //verify(adminServiceImpl).

    }


}
