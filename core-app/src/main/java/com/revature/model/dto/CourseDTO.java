package com.revature.model.dto;

public class CourseDTO {
	private Integer id;
	private String title;
	private String description;
	private Integer enrollmentpoints;
	private Integer completionpoints;

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

	public void setDescription(String decription) {
		this.description = decription;
	}

	public Integer getEnrollmentpoints() {
		return enrollmentpoints;
	}

	public void setEnrollmentpoints(Integer enrollmentpoints) {
		this.enrollmentpoints = enrollmentpoints;
	}

	public Integer getCompletionpoints() {
		return completionpoints;
	}

	public void setCompletionpoints(Integer completionpoints) {
		this.completionpoints = completionpoints;
	}

	public void setQuizEnrollmentPoints(Object o) {
		if (o != null) {
			this.enrollmentpoints = Integer.parseInt(o.toString());
		}
	}

	public Object getQuizEnrollmentPoints() {
		return 0;
	}

	public void setQuizCompletionPoints(Object o) {
		if (o != null) {
			this.completionpoints = Integer.parseInt(o.toString());
		}
	}

	public Object getQuizCompletionPoints() {
		return 0;
	}

	public void setQuizId(Object o) {
		if (o != null) {
			this.id = Integer.parseInt(o.toString());
		}
	}

	public Object getQuizId() {
		return 0;
	}
}
