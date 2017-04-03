package com.revature.biz;

import java.math.BigInteger;
import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.Project;
import com.revature.model.dto.ProjectDTO;

public interface ProjectService {
	public List<Project> getTopProjects() throws BusinessServiceException;
	
	public List<Project> getTop10Projects() throws BusinessServiceException;

	public List<Project> getProjectTitle() throws BusinessServiceException;

	public BigInteger getProjectEnrolledCount(Integer projectId) throws BusinessServiceException;

	public ProjectDTO getDetails(Integer project) throws BusinessServiceException;
}
