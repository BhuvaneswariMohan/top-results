package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.biz.RevtekPortfolioService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.RevtekPortfolio;
import com.revature.model.dto.RevtekPortfolioDTO;

@RestController
@RequestMapping("/")
public class RevtekPortfolioController {

	private static Logger logger = Logger.getLogger(RevtekPortfolioController.class);

	@Autowired
	private RevtekPortfolioService revtekPortfolioService;

	@GetMapping("/aboutme/{abt}")
	public RevtekPortfolioDTO getAboutMeById(@PathVariable ("abt") Integer studentId) {
		RevtekPortfolioDTO students = null;
		try {
			logger.info("About me is retriving ...");
			students = revtekPortfolioService.getAboutMeById(studentId);
			logger.info("About me data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return students;
	}

	@GetMapping("/qualification/{qualif}")
	public List<RevtekPortfolio> getQualificationById(@PathVariable ("qualif") Integer studentId) {
		List<RevtekPortfolio> students = null;
		try {
			logger.info("Qualification is retriving ...");
			students = revtekPortfolioService.getQualificationById(studentId);
			logger.info("Qualification data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return students;
	}
	@GetMapping("/certification/{studentId}")
	public List<RevtekPortfolio> getCertificationById(@PathVariable ("studentId") Integer studentId) {
		List<RevtekPortfolio> certifications = null;
		try {
			logger.info("Qualification is retriving ...");
			certifications = revtekPortfolioService.getCertificationById(studentId);
			logger.info("Qualification data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return certifications;
	}
	
	@GetMapping("/industrialEquivalency/{studentId}")
	public List<RevtekPortfolio> getIndustrialEquivalencyById(@PathVariable ("studentId") Integer studentId) {
		List<RevtekPortfolio> certifications = null;
		try {
			logger.info("Industrial Equivalency is retriving ...");
			certifications = revtekPortfolioService.getIndustrialEquivalencyById(studentId);
			logger.info("Qualification data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return certifications;
	}
}
