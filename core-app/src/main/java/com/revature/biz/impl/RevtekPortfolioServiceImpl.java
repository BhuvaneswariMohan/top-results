package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.biz.RevtekPortfolioService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.RevtekPortfolioDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.RevtekPortfolio;
import com.revature.model.dto.RevtekPortfolioDTO;

@Service
public class RevtekPortfolioServiceImpl implements RevtekPortfolioService {

	private static Logger logger = Logger.getLogger(RevtekPortfolioServiceImpl.class);

	@Autowired
	private RevtekPortfolioDAO revtekPortfolioDAO;

	public RevtekPortfolioDTO getAboutMeById(Integer studentId) throws BusinessServiceException {
		RevtekPortfolioDTO students;
		try {
			students = (RevtekPortfolioDTO) revtekPortfolioDAO.getAboutMeById(studentId);
			logger.info("About me details retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);

		}
		return students;
	}

	public List<RevtekPortfolio> getQualificationById(Integer studentId) throws BusinessServiceException {
		List<RevtekPortfolio> students;
		try {
			students = revtekPortfolioDAO.getQualificationById(studentId);
			logger.info("Projects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);

		}

		return students;
	}

	@Override
	public List<RevtekPortfolio> getCertificationById(Integer studentId) throws BusinessServiceException {
		List<RevtekPortfolio> certificates;
		try {
			certificates = revtekPortfolioDAO.getCertificationsById(studentId);
			logger.info("Projects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);

		}
		return certificates;
	}

	@Override
	public List<RevtekPortfolio> getIndustrialEquivalencyById(Integer studentId) throws BusinessServiceException {
		List<RevtekPortfolio> industrialEquivalency;
		try {
			industrialEquivalency = revtekPortfolioDAO.getIndustrialEquivalencyById(studentId);
			logger.info("Projects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);

		}
		return industrialEquivalency;
	}
}
