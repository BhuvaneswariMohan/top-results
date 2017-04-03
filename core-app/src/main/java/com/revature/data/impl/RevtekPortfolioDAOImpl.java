package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.revature.data.RevtekPortfolioDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.RevtekPortfolio;
import com.revature.model.dto.RevtekPortfolioDTO;

@Repository
public class RevtekPortfolioDAOImpl implements RevtekPortfolioDAO {
	private static Logger logger = Logger.getLogger(RevtekPortfolioDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public RevtekPortfolioDTO getAboutMeById(Integer studentId) throws DataServiceException {
		RevtekPortfolioDTO students = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT ID studentId,NAME stuName,ABOUT_ME aboutMe,MOBILE_NUMBER rsMobileNumber,EMAIL_ID stuEmailId FROM GET_STUDENTPORTFOLIO_ABOUT_ME WHERE ID="
							+ studentId);
			students = (RevtekPortfolioDTO) dataRetriver.retrieveOneBySQL(sb.toString(), RevtekPortfolioDTO.class);
			logger.info("About me data retrieval success.." + studentId);
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return students;
	}

//	public List<> getQualificationById(Integer studentId) throws DataServiceException {
//		RevtekPortfolioDTO students = null;
//		try {
//            StringBuilder sb = new StringBuilder("SELECT * from GET_STUDENTPORTFOLIO_QUALIFICATION WHERE ID ="+studentId);
//			students = (RevtekPortfolioDTO) dataRetriver.retrieveOneBySQL(sb.toString(), RevtekPortfolioDTO.class);
//			logger.info("Qualification data retrieval success.." + studentId);
//		} catch (DataAccessException e) {
//			logger.error(e.getMessage(), e);
//			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
//		}
//		return students;
//	}
	public List<RevtekPortfolio> getQualificationById(Integer studentId) throws DataServiceException {
		List<RevtekPortfolio> projects = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT * FROM GET_STUDENTPORTFOLIO_QUALIFICATION WHERE ID ="+studentId);
			projects = dataRetriver.retrieveBySQLJSON(sb.toString());
			logger.info("Success");

		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("Failed"));

		}
		return projects;
	}

	@Override
	public List<RevtekPortfolio> getCertificationsById(Integer studentId) throws DataServiceException {
		List<RevtekPortfolio> certificates  = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT * FROM GET_STUDENTPORTFOLIO_CERTIFICATION WHERE ID ="+studentId);
			certificates = dataRetriver.retrieveBySQLJSON(sb.toString());
			logger.info("Success");

		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("Failed"));

		}
		return certificates;
	}

	@Override
	public List<RevtekPortfolio> getIndustrialEquivalencyById(Integer studentId) throws DataServiceException {
		List<RevtekPortfolio> industrialEquivalency  = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT * FROM GET_STUDENTPORTFOLIO_INDUSTRIAL_EQUIVALENCY WHERE ID ="+studentId);
			industrialEquivalency = dataRetriver.retrieveBySQLJSON(sb.toString());
			logger.info("Success");

		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("Failed"));

		}
		return industrialEquivalency;
	}

}
