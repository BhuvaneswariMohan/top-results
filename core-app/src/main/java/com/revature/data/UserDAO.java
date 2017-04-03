package com.revature.data;



import com.revature.data.exception.DataServiceException;
import com.revature.model.dto.UserDTO;



public interface UserDAO {
	

	public UserDTO getUserdetailsbyid(Integer userid) throws DataServiceException;
	public UserDTO getUserloginbyid(String emailid,String password) throws DataServiceException;

	public String updatePassword(String emailId,String newPassword) throws DataServiceException;

	

}
