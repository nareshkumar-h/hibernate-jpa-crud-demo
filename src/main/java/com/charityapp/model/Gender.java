package com.charityapp.model;

public enum Gender {

	MALE("M"),FEMALE("F");
	
	private String gender;
	
	private Gender(String gender) {
		this.gender = gender;
	}
	
	public String toString() {
		return this.gender;
	}
	
	public static Gender toGender(String value) {
		Gender g = null;
		for (Gender gender : Gender.values()) {
			if(gender.toString().equals(value)) {
				g= gender;
				break;
			}
		}
		return g;
	}
	
	
}
