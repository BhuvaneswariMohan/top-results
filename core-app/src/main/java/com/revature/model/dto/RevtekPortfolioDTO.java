package com.revature.model.dto;

import java.sql.Date;

public class RevtekPortfolioDTO {
	private Integer stuId;
	private String stuName;
	private String aboutMe;
	private Long stuMobileNumber;
	private String stuEmailId;
	private Integer revportId;
	private String seedDegree;
	private String seedMajor;
	private String qUniv;
	private Float qCgpa;
	private String gradMonth;
	private Date gradYear;
	
	public Float getqCgpa() {
		return qCgpa;
	}
	
	public String getGradMonth() {
		return gradMonth;
	}

	public void setGradMonth(String gradMonth) {
		this.gradMonth = gradMonth;
	}

	public Date getGradYear() {
		return gradYear;
	}

	public void setGradYear(Date gradYear) {
		this.gradYear = gradYear;
	}

	public void setqCgpa(Float qCgpa) {
		this.qCgpa = qCgpa;
	}
	public String getqUniv() {
		return qUniv;
	}
	public void setqUniv(String qUniv) {
		this.qUniv = qUniv;
	}
	public String getSeedMajor() {
		return seedMajor;
	}
	public void setSeedMajor(String seedMajor) {
		this.seedMajor = seedMajor;
	}
	public String getSeedDegree() {
		return seedDegree;
	}
	public void setSeedDeg(String seedDegree) {
		this.seedDegree = seedDegree;
	}
	
	public Integer getRevportId() {
		return revportId;
	}
	public void setRevportId(Integer revportId) {
		this.revportId = revportId;
	}
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public Long getStuMobileNumber() {
		return stuMobileNumber;
	}
	public void setStuMobileNumber(Long stuMobileNumber) {
		this.stuMobileNumber = stuMobileNumber;
	}
	public String getStuEmailId() {
		return stuEmailId;
	}
	public void setStuEmailId(String stuEmailId) {
		this.stuEmailId = stuEmailId;
	}
	public void setStudentId(Object o) {
		if (o != null) {
			this.stuId = Integer.parseInt(o.toString());
		}
	}

	public Object getRsMobileNumber() {
		return 0;
	}
	public void setRsMobileNumber(Object o) {
		if (o != null) {
			this.stuMobileNumber = Long.parseLong(o.toString());
		}
	}

	public Object getStudentId() {
		return 0;
	}
	public Object getRpId() {
		return 0;
	}
	public void setRpId(Object o) {
		if (o != null) {
			this.revportId = Integer.parseInt(o.toString());
		}
	}
}
