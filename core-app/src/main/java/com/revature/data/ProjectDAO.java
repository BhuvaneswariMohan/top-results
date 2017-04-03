package com.revature.data;

import java.math.BigInteger;
import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Project;

public interface ProjectDAO {
	public List<Project> getTopProjects() throws DataServiceException;
	
	public List<Project> getTop10Projects() throws DataServiceException;

	public List<Project> getProjectTitle() throws DataServiceException;

	public BigInteger getProjectEnrolledCount(Integer projectId) throws DataServiceException;

	public<E> Object getProjectdetailsbyname(Integer projectId) throws DataServiceException;
}
