package com.practice.atlassianDesignCode.Model;

public class Lap {

	private int lapNumber;
	
	private double lapDuration;
	
	
	
	public Lap(int lapNumber, double lapDuration) {
		super();
		this.lapNumber = lapNumber;
		this.lapDuration = lapDuration;
	}
	
	public int getLapNumber() {
		return lapNumber;
	}
	public void setLapNumber(int lapNumber) {
		this.lapNumber = lapNumber;
	}
	public double getLapDuration() {
		return lapDuration;
	}
	public void setLapDuration(double lapDuration) {
		this.lapDuration = lapDuration;
	}
	
	
	
}
