package com.revature.controller;

import java.math.BigInteger;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.ProjectService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.Project;
import com.revature.model.dto.ProjectDTO;

@RestController
@RequestMapping("/")
public class ProjectController {

	private static Logger logger = Logger.getLogger(ProjectController.class);

	@Autowired
	private ProjectService projectService;

	@GetMapping("/projectdetails/{proj}")
	public ProjectDTO getDetailsController(@PathVariable ("proj") Integer project) {
		System.out.println(project);
		ProjectDTO projects = null;
		try {
						logger.info("Getting the projects data...");
						System.out.println(project);
			projects = (ProjectDTO) projectService.getDetails(project);
			return projects;
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
	}
	
	@RequestMapping("/topprojects")
	public List<Project> getTopProjects() {
		List<Project> projects = null;
		try {
			logger.info("Getting the projects data...");
			projects = projectService.getTopProjects();
			logger.info("Projects data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return projects;
	}

	@RequestMapping("/projecttitle")
	public List<Project> getProjectTitle() {
		List<Project> projects = null;
		try {
			logger.info("Getting the project titles data...");
			projects = projectService.getProjectTitle();
			logger.info("Project titles data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return projects;
	}

	@RequestMapping("/studentsenrolledforprojects")
	public BigInteger getProjectEnrolledCount(Integer projectId) {
		BigInteger studentCount;
		try {
			logger.info("Getting the enrolled students for projects data...");
			studentCount = projectService.getProjectEnrolledCount(projectId);
			logger.info("Projects enrolled data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentCount;

	}

	@RequestMapping("/topTenProjects")
	public List<Project> getTop10Projects() {
		List<Project> projects = null;
		try {
			logger.info("Getting the projects data...");
			projects = projectService.getTop10Projects();
			logger.info("Projects data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return projects;
	}

	
}
