package com.revature.data.impl;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.UserDAO;
import com.revature.data.access.DataModifier;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}
	@Autowired
	private DataModifier dataModifier;

	public DataModifier getDataModifier() {
		return dataModifier;
	}

	public void setDataModifier(DataModifier dataModifier) {
		this.dataModifier = dataModifier;
	}


	@Override
	public UserDTO getUserdetailsbyid(Integer userid) throws DataServiceException {
		UserDTO users = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT USERNAME name,EMAIL_ID emailid FROM users WHERE users.ID =" + userid);
			users = (UserDTO) dataRetriver.retrieveOneBySQL(sb.toString(),UserDTO.class);
			logger.info("Users data retrieval success.." + users);
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return users;
	}

	public UserDTO getUserloginbyid(String emailid, String password) throws DataServiceException {
		UserDTO users = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT ID id,USERNAME name,EMAIL_ID emailid FROM users WHERE EMAIL_ID='" + emailid + "'" + " and PASSWORD='" + password + "'");
			users = (UserDTO)dataRetriver.retrieveOneBySQL(sb.toString(),UserDTO.class);

			logger.info("Users data retrieval success.." + users);
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return users;
	}

	@Override
	public String updatePassword(String emailId,String newPassword) throws DataServiceException {
		int rows = 0;
		String msg = null;
		try {
			StringBuilder sb = new StringBuilder("UPDATE users SET PASSWORD='" + newPassword + "'"
					+ " WHERE EMAIL_ID='" + emailId + "'");		
		 rows = dataModifier.modifyBySQL(sb.toString());			
			if(rows == 0)
				msg = "Password not updated";
			if(rows == 1)
				msg = "Password updated";
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_modifier_fail"), e);
		}
		logger.info(msg);
		return msg;
		
	}
}
