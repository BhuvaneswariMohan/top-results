package com.revature.model.dto;

public class QuizDTO {
	private Integer id;
	private String title;
	private String description;
	private Integer activityPoints;
	private Integer numberOfAttempts;
	private Float passPercentage;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getActivityPoints() {
		return activityPoints;
	}

	public void setActivityPoints(Integer activityPoints) {
		this.activityPoints = activityPoints;
	}

	public Integer getNumberOfAttempts() {
		return numberOfAttempts;
	}

	public void setNumberOfAttempts(Integer numberOfAttempts) {
		this.numberOfAttempts = numberOfAttempts;
	}

	public Float getPassPercentage() {
		return passPercentage;
	}

	public void setPassPercentage(Float passPercentage) {
		this.passPercentage = passPercentage;
	}

	public void setQuizId(Object o) {
		if (o != null) {
			this.id = Integer.parseInt(o.toString());
		}
	}

	public Object getQuizId() {
		return 0;
	}

	public void setQuizActivityPoints(Object o) {
		if (o != null) {
			this.activityPoints = Integer.parseInt(o.toString());
		}
	}

	public Object getQuizActivityPoints() {
		return 0;
	}

	public void setQuizNumberOfAttempts(Object o) {
		if (o != null) {
			this.numberOfAttempts = Integer.parseInt(o.toString());
		}
	}

	public Object getQuizNumberOfAttempts() {
		return 0;
	}

	public void setQuizPassPercentage(Object o) {
		if (o != null) {
			this.passPercentage = Float.parseFloat(o.toString());
		}
	}

	public Object getQuizPassPercentage() {
		return 0;
	}

}
