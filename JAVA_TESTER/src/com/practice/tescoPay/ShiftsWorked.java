package com.practice.tescoPay;

public class ShiftsWorked  extends BaseEntity{

	
	public ShiftsWorked(String uid) {
		super(uid);
		
	}
	private String skill;
	private Double totalDuration;
	private Double breakDuration;
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Double getTotalDuration() {
		return totalDuration;
	}
	public void setTotalDuration(Double totalDuration) {
		this.totalDuration = totalDuration;
	}
	public Double getBreakDuration() {
		return breakDuration;
	}
	public void setBreakDuration(Double breakDuration) {
		this.breakDuration = breakDuration;
	}
	
	
	
}
