package com.cg.tms.beans;
import java.util.Set;

import com.cg.tms.enums.Skills;

public class Trainer {

	private String trainerId;
	private String trainerName;
	private String trainerAddress;
	private Set<Skills> skills;
	public static int trainerSeq=10;
	
	public Trainer(String trainerId, String trainerName, String trainerAddress, Set<Skills> skills) {
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.trainerAddress = trainerAddress;
		this.skills = skills;
		trainerSeq++;
	}
	public Trainer() {
	}
	public String getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getTrainerAddress() {
		return trainerAddress;
	}
	public void setTrainerAddress(String trainerAddress) {
		this.trainerAddress = trainerAddress;
	}
	public Set<Skills> getSkills() {
		return skills;
	}
	public void setSkills(Set<Skills> skills) {
		this.skills = skills;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.trainerId.equals(((Trainer)obj).trainerId);
	}
	@Override
	public int hashCode() {
		return this.trainerId.hashCode();
	}
	@Override
	public String toString() {
		return "ID: "+trainerId+" Name: "+trainerName+" Skills"+skills;
	}




}