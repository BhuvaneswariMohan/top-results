package com.revature.biz;



import com.revature.biz.exception.BusinessServiceException;

import com.revature.model.dto.UserDTO;

public interface UserService {

	/**
	 * Used to get all the categories.
	 * 
	 * @return categories
	 * @throws BusinessServiceException
	 *             if any business error occurs
	 */
	UserDTO getDetails(Integer userid) throws BusinessServiceException;

    UserDTO getUserloginbyid(String emailid, String password) throws BusinessServiceException;
    
    public String updatePassword(String emailId,String newPassword) throws BusinessServiceException;

}