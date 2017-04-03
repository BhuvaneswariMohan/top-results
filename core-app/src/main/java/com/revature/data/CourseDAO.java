package com.revature.data;

import java.math.BigInteger;
import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Course;

public interface CourseDAO {
	public List<Course> getAllCourses() throws DataServiceException;

	public List<Course> getTopCourses() throws DataServiceException;
	
	public List<Course> getTop10Courses() throws DataServiceException;

	public List<Course> getCourseTitles() throws DataServiceException;

	public BigInteger getCourseEnrolledCount(Integer courseId) throws DataServiceException;

	public <E> Object getCoursedetailsbyId(Integer course) throws DataServiceException;
}
