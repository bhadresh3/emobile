package com.emobile;

import com.emobile.Admin.Service.AdminService;
import com.emobile.Admin.Service.AdminServiceImpl;
import com.emobile.User.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@SpringBootApplication
@EnableScheduling
public class EmobileConnectApplication {
//	@Autowired
//	AdminService adminService;

	public static void main(String[] args) {
		SpringApplication.run(EmobileConnectApplication.class, args);
	}

	@Scheduled(fixedDelay = 5000)
	public void cronJob(){
////		List<User> userList= adminService.findByApproved();
////		for(User user : userList){
////			user.setStatus("Activated");
////			adminService.save(user);
		System.out.println("hi" + System.currentTimeMillis());
	}
}

