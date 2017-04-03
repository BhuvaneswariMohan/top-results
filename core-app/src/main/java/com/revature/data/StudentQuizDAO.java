package com.revature.data;

import java.util.List;
import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentQuiz;

public interface StudentQuizDAO {
public List<StudentQuiz> getQuizzesTakenByStudents(Integer quizId) throws DataServiceException;
}
