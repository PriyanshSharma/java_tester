package com.practice.atlassianDesignCode.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Driver {

	private String driverId;
	
	private List<Lap> driversLap;

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public List<Lap> getDriversLap() {
		return driversLap;
	}

	public void setDriversLap(List<Lap> driversLap) {
		this.driversLap = driversLap;
	}

	public Driver(String driverId) {
		super();
		this.driverId = driverId;//UUID.randomUUID().toString();
		this.driversLap = new ArrayList<Lap>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(driverId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		return Objects.equals(driverId, other.driverId);
	}
	
	
}
