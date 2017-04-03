package com.revature.data.impl;

import java.math.BigInteger;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.revature.data.CourseDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Course;
import com.revature.model.dto.CourseDTO;

@Repository
public class CourseDAOImpl implements CourseDAO {
	private static Logger logger = Logger.getLogger(CourseDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<Course> getAllCourses() throws DataServiceException {
		List<Course> courses = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT * FROM courses");
			courses = dataRetriver.retrieveBySQLJSON(sb.toString());
			logger.info("Courses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return courses;
	}

	public List<Course> getTopCourses() throws DataServiceException {
		List<Course> courses = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT courses.`ID`, courses.`TITLE` AS COURSE_NAME, COUNT(student_courses.`COURSE_ID`) AS ENROLLED_STUDENTS FROM student_courses JOIN courses ON courses.`ID` = student_courses.`COURSE_ID` GROUP BY COURSE_ID ORDER BY COUNT(COURSE_ID) DESC LIMIT 5");
			courses = dataRetriver.retrieveBySQLJSON(sb.toString());
			logger.info("Success");

		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("Failed"));

		}
		return courses;
	}

	public List<Course> getCourseTitles() throws DataServiceException {
		List<Course> courses = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT TITLE,DESCRIPTION FROM courses");
			courses = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Success");

		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("Failed"));

		}
		return courses;
	}

	public BigInteger getCourseEnrolledCount(Integer courseId) throws DataServiceException {
		BigInteger studentCount;
		try {
			StringBuilder sb = new StringBuilder("SELECT COUNT(id) FROM student_courses WHERE COURSE_ID= " + courseId);
			studentCount = (BigInteger) dataRetriver.retrieveBySQLInt(sb.toString());
			logger.info("students enrolled courses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCount;
	}

	public CourseDTO getCoursedetailsbyId(Integer courseId) throws DataServiceException {
		CourseDTO courses = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT ID quizId,TITLE title,DESCRIPTION description,ENROLLMENT_POINTS quizEnrollmentPoints,COMPLETION_POINTS quizCompletionPoints FROM courses WHERE ID="
							+ courseId);
			courses = (CourseDTO) dataRetriver.retrieveOneBySQL(sb.toString(), CourseDTO.class);
			logger.info("Courses data retrieval success.." + courses);
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return courses;
	}

	@Override
	public List<Course> getTop10Courses() throws DataServiceException {
		List<Course> topTenCourses = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT courses.`ID`, courses.`TITLE` AS COURSE_NAME, COUNT(student_courses.`COURSE_ID`) AS ENROLLED_STUDENTS FROM student_courses JOIN courses ON courses.`ID` = student_courses.`COURSE_ID` GROUP BY COURSE_ID ORDER BY COUNT(COURSE_ID) DESC LIMIT 10");
			topTenCourses = dataRetriver.retrieveBySQLJSON(sb.toString());
			logger.info("Success");

		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("Failed"));

		}
		return topTenCourses;
	}
}
