package com.revature.controller;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.revature.biz.UserService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.dto.UserDTO;

@RestController
@RequestMapping("/")
public class UserController {

	private static Logger logger = Logger.getLogger(ProjectController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/Users/{userid}")
	public UserDTO getDetailsController(@PathVariable("userid") Integer userId) {
		UserDTO users = null;
		try {
			logger.info("Getting the users data...");
			users = userService.getDetails(userId);
			return users;
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
	}

	@PostMapping("/login")
	public UserDTO getUserloginbyidController(@RequestParam("emailid") String emailid,
			@RequestParam("password") String password) {
		UserDTO users;
		try {
			logger.info("Getting the users data...");
			users = userService.getUserloginbyid(emailid, password);
			return users;
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
	}
	

	@PostMapping("/updatePassword")
	public String updateUserPasswordController(@RequestParam("emailId") String emailId,@RequestParam("newPassword") String newPassword) {
		String msg = null;
		try {
			logger.info("Getting the users data...");
			msg = userService.updatePassword(emailId, newPassword);
			return msg;
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
	}
	
}
