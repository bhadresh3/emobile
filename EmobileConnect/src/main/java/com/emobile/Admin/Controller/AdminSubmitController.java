package com.emobile.Admin.Controller;

import com.emobile.Admin.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/adminRequest")
public class AdminSubmitController {

    private AdminService adminService;

    @Autowired
    public AdminSubmitController(AdminService adminService) {
        this.adminService = adminService;

    }

    @PostMapping(value="/status/{requestId}")
    @ResponseStatus(HttpStatus.OK)
    public void ChangeStatus(@PathVariable String requestId, @RequestParam(name = "status") String Status){
        String newStatus;
        if(Status.equals("1")){
            newStatus = "Approved";
        }else if(Status.equals("2")){
            newStatus = "Rejected";
        }else if(Status.equals(("3"))){
            newStatus = "Change Require";
        }else{
            newStatus = "unidentified";
        }
        adminService.postStatus(requestId, newStatus);
    }
}
