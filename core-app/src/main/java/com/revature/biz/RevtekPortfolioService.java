package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.RevtekPortfolio;
import com.revature.model.dto.RevtekPortfolioDTO;

public interface RevtekPortfolioService {
	public RevtekPortfolioDTO getAboutMeById(Integer studentId) throws BusinessServiceException;

	public List<RevtekPortfolio> getQualificationById(Integer studentId) throws BusinessServiceException;
	
	public List<RevtekPortfolio> getCertificationById(Integer studentId) throws BusinessServiceException;
	
	public List<RevtekPortfolio> getIndustrialEquivalencyById(Integer studentId) throws BusinessServiceException;
}
