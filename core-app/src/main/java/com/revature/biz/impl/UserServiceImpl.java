package com.revature.biz.impl;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.UserService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.UserDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.dto.UserDTO;


@Service
public class UserServiceImpl implements UserService {

	private static Logger logger = Logger.getLogger(CategoryServiceImpl.class);

	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDTO getDetails(Integer userid) throws BusinessServiceException {
		UserDTO users = null;
		try {
			users = userDAO.getUserdetailsbyid(userid);
			logger.info("users retrieved successfully"+users);
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return users;
	}
	public UserDTO getUserloginbyid(String emailid,String password) throws BusinessServiceException{
		UserDTO users = null;
		try {
			users = userDAO.getUserloginbyid(emailid,password);
			logger.info("users retrieved successfully"+users);
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return users;
	}
	@Override
	public String updatePassword(String emailId,String newPassword) throws BusinessServiceException {
		String msg = null;
		try {
			msg = userDAO.updatePassword(emailId, newPassword);
			logger.info("user password updated successfully"+msg);
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return msg;
	}
}

