package com.revature.data.impl;

import java.math.BigInteger;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.revature.data.QuizDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Quiz;
import com.revature.model.dto.QuizDTO;

@Repository
public class QuizDAOImpl implements QuizDAO {
	private static Logger logger = Logger.getLogger(CourseDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	public List<Quiz> getTopQuizzes() throws DataServiceException {
		List<Quiz> quizzes = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT quizzes.`ID`, quizzes.`TITLE` AS QUIZ_NAME, COUNT(student_quizzes.QUIZ_ID) AS ENROLLED_STUDENTS FROM student_quizzes JOIN quizzes ON quizzes.`ID` = student_quizzes.`QUIZ_ID` GROUP BY QUIZ_ID ORDER BY COUNT(QUIZ_ID) DESC LIMIT 5");
			quizzes = dataRetriver.retrieveBySQLJSON(sb.toString());
			logger.info("Success");

		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("Failed"));

		}
		return quizzes;
	}

	public List<Quiz> getQuizTitles() throws DataServiceException {
		List<Quiz> quizzes = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT TITLE,DESCRIPTION FROM quizzes");
			quizzes = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Success");

		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("Failed"));

		}
		return quizzes;
	}

	public BigInteger getQuizEnrolledCount(Integer quizId) throws DataServiceException {
		BigInteger studentCount;
		try {
			StringBuilder sb = new StringBuilder("SELECT COUNT(id) FROM student_quizzes WHERE QUIZ_ID= " + quizId);
			studentCount = (BigInteger) dataRetriver.retrieveBySQLInt(sb.toString());
			logger.info("students enrolled for quizzes data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCount;
	}

	public QuizDTO getQuizdetailsbyname(Integer quizId) throws DataServiceException {
		QuizDTO quizzes = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT ID quizId,TITLE title,DESCRIPTION description,ACTIVITY_POINTS quizActivityPoints,NUMBER_OF_ATTEMPTS quizNumberOfAttempts,PASS_PERCENTAGE quizPassPercentage FROM vw_quiz_details WHERE ID="
							+ quizId);
			quizzes = (QuizDTO) dataRetriver.retrieveOneBySQL(sb.toString(), QuizDTO.class);
			logger.info("Quizzes data retrieval success.." + quizId);
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return quizzes;
	}

	@Override
	public List<Quiz> getTop10Quizzes() throws DataServiceException {
		List<Quiz> topTenQuizzes = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT quizzes.`ID`, quizzes.`TITLE` AS QUIZ_NAME, COUNT(student_quizzes.QUIZ_ID) AS ENROLLED_STUDENTS FROM student_quizzes JOIN quizzes ON quizzes.`ID` = student_quizzes.`QUIZ_ID` GROUP BY QUIZ_ID ORDER BY COUNT(QUIZ_ID) DESC LIMIT 10");
			topTenQuizzes = dataRetriver.retrieveBySQLJSON(sb.toString());
			logger.info("Success");

		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("Failed"));

		}
		return topTenQuizzes;
	}
}
