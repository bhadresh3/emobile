package com.emobile;

import com.emobile.Admin.Service.AdminService;
import com.emobile.Admin.Service.AdminServiceImpl;
import com.emobile.User.Model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@SpringBootApplication
@EnableScheduling
public class EmobileConnectApplication {
	@Autowired
	AdminService adminService;
	private static final Logger LOGGER = LoggerFactory.getLogger(EmobileConnectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmobileConnectApplication.class, args);
	}

	@Scheduled(fixedDelay = 100000)
	public void cronJob() {
		List<User> userList = adminService.findByApproved();
		for (User user : userList) {
			LOGGER.info("Batch job started for user {}", user.getFirstName());
			user.setStatus("Activated");
			adminService.save(user);
		}
	}
}

