package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.RevtekPortfolio;

public interface RevtekPortfolioDAO {
	public <E> Object getAboutMeById(Integer studentId) throws DataServiceException;

	public List<RevtekPortfolio> getQualificationById(Integer studentId) throws DataServiceException;
	
	public List<RevtekPortfolio> getCertificationsById(Integer studentId) throws DataServiceException;
	
	public List<RevtekPortfolio> getIndustrialEquivalencyById(Integer studentId) throws DataServiceException;
}
