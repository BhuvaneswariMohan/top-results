package com.revature.model.dto;

public class ProjectDTO {
	private Integer id;
	private String title;
	private String description;
	private String mentorName;
	private String emailId;
	private Integer enrollmentpoints;
	private Integer completionpoints;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public void setProEnrollmentPoints(Object o) {
		if (o != null) {
			this.enrollmentpoints = Integer.parseInt(o.toString());
		}
	}

	public Object getProEnrollmentPoints() {
		return 0;
	}

	public void setProCompletionPoints(Object o) {
		if (o != null) {
			this.completionpoints = Integer.parseInt(o.toString());
		}
	}

	public Object getProCompletionPoints() {
		return 0;
	}

	public void setProId(Object o) {
		if (o != null) {
			this.id = Integer.parseInt(o.toString());
		}
	}

	public Object getProId() {
		return 0;
	}
}
