package com.revature.data.impl;

import java.math.BigInteger;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.revature.data.ProjectDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Project;
import com.revature.model.dto.ProjectDTO;

@Repository
public class ProjectDAOImpl implements ProjectDAO {
	private static Logger logger = Logger.getLogger(ProjectDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	public List<Project> getTopProjects() throws DataServiceException {
		List<Project> projects = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT projects.`ID`,projects.`TITLE` AS Project_NAME, COUNT(student_projects.`PROJECT_ID`) AS ENROLLED_STUDENTS FROM student_projects JOIN projects ON projects.`ID` = student_projects.`PROJECT_ID` GROUP BY PROJECT_ID ORDER BY COUNT(PROJECT_ID) DESC LIMIT 5");
			projects = dataRetriver.retrieveBySQLJSON(sb.toString());
			logger.info("Success");

		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("Failed"));

		}
		return projects;
	}

	public List<Project> getProjectTitle() throws DataServiceException {
		List<Project> projects = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT TITLE,DESCRIPTION FROM projects");
			projects = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Success");

		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("Failed"));

		}
		return projects;
	}

	public BigInteger getProjectEnrolledCount(Integer projectId) throws DataServiceException {
		BigInteger studentCount;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT COUNT(id) FROM student_projects WHERE PROJECT_ID= " + projectId);
			studentCount = (BigInteger) dataRetriver.retrieveBySQLInt(sb.toString());
			logger.info("students enrolled projects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCount;
	}

	public ProjectDTO getProjectdetailsbyname(Integer projectId) throws DataServiceException {
		ProjectDTO projects = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT ID proId,TITLE title,DESCRIPTION description,NAME mentorName,EMAIL_ID emailId,ENROLLMENT_POINTS proEnrollmentPoints,COMPLETION_POINTS proCompletionPoints FROM vw_project_details WHERE ID="
							+ projectId);
			projects = (ProjectDTO) dataRetriver.retrieveOneBySQL(sb.toString(), ProjectDTO.class);
			logger.info("Projects data retrieval success.." + projects);
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return projects;
	}

	@Override
	public List<Project> getTop10Projects() throws DataServiceException {
		List<Project> topTenProjects = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT projects.`ID`,projects.`TITLE` AS Project_NAME, COUNT(student_projects.`PROJECT_ID`) AS ENROLLED_STUDENTS FROM student_projects JOIN projects ON projects.`ID` = student_projects.`PROJECT_ID` GROUP BY PROJECT_ID ORDER BY COUNT(PROJECT_ID) DESC LIMIT 10");
			topTenProjects = dataRetriver.retrieveBySQLJSON(sb.toString());
			logger.info("Success");

		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("Failed"));

		}
		return topTenProjects;
	}

}
