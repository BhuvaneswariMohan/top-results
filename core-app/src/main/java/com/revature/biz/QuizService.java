package com.revature.biz;

import java.math.BigInteger;
import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.Quiz;
import com.revature.model.dto.QuizDTO;

public interface QuizService {
	public List<Quiz> getTopQuizzes() throws BusinessServiceException;
	
	public List<Quiz> getTop10Quizzes() throws BusinessServiceException;

	public List<Quiz> getQuizTitles() throws BusinessServiceException;

	public BigInteger getQuizEnrolledCount(Integer quizId) throws BusinessServiceException;

	public QuizDTO getDetails(Integer quiz) throws BusinessServiceException;
}
